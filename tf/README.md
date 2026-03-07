# Infrastructure as Code - Terraform Configuration

Complete Terraform infrastructure setup for deploying the Flight Reservation & Check-In application on AWS with EKS, RDS, and S3.

---

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Architecture](#architecture)
- [Modules](#modules)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Deployment Guide](#deployment-guide)
- [Module Details](#module-details)
- [Environment Variables](#environment-variables)
- [Managing Infrastructure](#managing-infrastructure)
- [Monitoring](#monitoring)
- [Troubleshooting](#troubleshooting)
- [Cost Estimation](#cost-estimation)

---

## 🎯 Project Overview

This Terraform configuration automates the provisioning of the entire AWS infrastructure required to run the Flight Reservation & Check-In application in a production-grade environment.

### Infrastructure Components:
- **EKS Cluster** - Managed Kubernetes service for container orchestration
- **RDS MySQL Databases** - Managed relational databases for flight and check-in data
- **S3 Buckets** - Object storage for logs, backups, and static assets
- **IAM Roles & Policies** - Fine-grained access control
- **Security Groups** - Network security and firewall rules
- **VPC & Networking** - Virtual network infrastructure
- **Auto-scaling** - Automatic scaling based on demand

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────┐
│                     AWS Account                         │
└─────────────────────────────────────────────────────────┘
                          │
         ┌────────────────┼────────────────┐
         │                │                │
    ┌────▼────┐      ┌────▼─────┐    ┌────▼───┐
    │ EKS      │      │ RDS      │    │ S3     │
    │ Cluster  │      │ Database │    │ Bucket │
    │          │      │          │    │        │
    │ ┌──────┐ │      │ flightdb │    │ logs/  │
    │ │ Pods │ │      │ checkin  │    │ backup │
    │ │  K8s │ │      │_db       │    │ static │
    │ └──────┘ │      └──────────┘    └────────┘
    │          │
    │ ┌─────┐  │
    │ │ LB  │  │
    │ └─────┘  │
    └──────────┘
         │
    ┌────▼────────────┐
    │ Route53 / DNS   │
    └─────────────────┘
```

---

## 📁 Project Structure

```
tf/
├── main.tf                          # Main Terraform configuration
├── variables.tf                     # Input variables (if at root)
├── outputs.tf                       # Output values (if at root)
├── terraform.tfvars                # Variable values (local development)
├── terraform.tfvars.example        # Example variable file
├── .gitignore                      # Git ignore patterns
├── modules/
│   ├── eks/                        # Kubernetes Cluster Module
│   │   ├── main.tf                # EKS cluster resources
│   │   ├── variable.tf            # Input variables
│   │   ├── output.tf              # Output values
│   │   └── README.md              # Module documentation
│   ├── rds/                        # Database Module
│   │   ├── main.tf                # RDS resources
│   │   ├── variable.tf            # Input variables
│   │   ├── output.tf              # Output values
│   │   └── README.md              # Module documentation
│   └── s3/                         # Storage Module
│       ├── main.tf                # S3 resources
│       ├── variable.tf            # Input variables
│       ├── output.tf              # Output values
│       └── README.md              # Module documentation
└── README.md                       # This file
```

---

## 🛠️ Prerequisites

### Required Tools
- **Terraform 1.0+** - Infrastructure as Code tool
- **AWS CLI v2** - Command-line interface for AWS
- **kubectl** - Kubernetes command-line tool
- **Git** - Version control

### AWS Requirements
- AWS Account with admin or appropriate permissions
- AWS credentials configured locally: `aws configure`
- Sufficient AWS service limits (EC2, ECS, RDS, S3)

### Local Setup

```bash
# Install Terraform (macOS with Homebrew)
brew install terraform

# Install AWS CLI
brew install awscli

# Install kubectl
brew install kubectl

# Verify installations
terraform -v
aws --version
kubectl version --client
```

---

## ⚙️ Configuration

### AWS Credentials

Configure AWS credentials with AWS CLI:

```bash
aws configure
# Enter: AWS Access Key ID
# Enter: AWS Secret Access Key
# Enter: Default region (e.g., us-east-1)
# Enter: Default output format (json)
```

Or set environment variables:

```bash
export AWS_ACCESS_KEY_ID="your-access-key"
export AWS_SECRET_ACCESS_KEY="your-secret-key"
export AWS_DEFAULT_REGION="us-east-1"
```

### Terraform Variables

Create `terraform.tfvars` from the example:

```bash
cp terraform.tfvars.example terraform.tfvars
```

Edit `terraform.tfvars`:

```hcl
# General
project_name     = "flight-reservation"
environment      = "production"
aws_region       = "us-east-1"
tags = {
  Project     = "FlightReservation"
  Environment = "production"
  CreatedBy   = "Terraform"
}

# EKS Configuration
cluster_version     = "1.27"
cluster_name        = "flight-eks-cluster"
desired_size        = 2
min_size            = 1
max_size            = 4
instance_type       = "t3.medium"

# RDS Configuration
db_engine_version   = "8.0.34"
db_instance_class   = "db.t3.micro"
allocated_storage   = 20
multi_az            = false

# S3 Configuration
s3_bucket_prefix    = "flight-reservation"
enable_versioning   = true
```

---

## 🚀 Deployment Guide

### Step 1: Initialize Terraform

```bash
cd tf/
terraform init
```

This downloads required providers and initializes the working directory.

### Step 2: Validate Configuration

```bash
terraform validate
```

Validates the syntax and configuration of all `.tf` files.

### Step 3: Plan Infrastructure

```bash
terraform plan -out=tfplan
```

Shows what resources will be created without making changes.

### Step 4: Apply Configuration

```bash
terraform apply tfplan
```

Creates the infrastructure on AWS.

### Step 5: Retrieve Outputs

```bash
terraform output
```

Displays important outputs like:
- EKS cluster endpoint
- RDS database endpoints
- S3 bucket names

### Step 6: Configure kubectl

```bash
aws eks update-kubeconfig \
  --region us-east-1 \
  --name flight-eks-cluster

kubectl get nodes
```

---

## 📚 Module Details

### EKS Module (eks/)

**Purpose:** Creates and manages the Kubernetes cluster

**Resources:**
- EKS Cluster
- Worker Node Groups
- IAM Roles and Policies
- Security Groups
- VPC Configuration
- Cluster Add-ons (VPC CNI, CoreDNS, kube-proxy)

**Variables:**
```hcl
variable "cluster_name" { type = string }
variable "cluster_version" { type = string }
variable "desired_size" { type = number }
variable "instance_type" { type = string }
```

**Outputs:**
```hcl
output "cluster_id" { value = aws_eks_cluster.main.id }
output "cluster_arn" { value = aws_eks_cluster.main.arn }
output "cluster_endpoint" { value = aws_eks_cluster.main.endpoint }
output "node_group_id" { value = aws_eks_node_group.main.id }
```

### RDS Module (rds/)

**Purpose:** Provisions managed MySQL databases

**Resources:**
- Two RDS Instances (flightdb, checkin_db)
- DB Subnet Groups
- DB Parameter Groups
- Security Groups
- Database Users and Permissions

**Variables:**
```hcl
variable "db_identifier" { type = string }
variable "allocated_storage" { type = number }
variable "engine_version" { type = string }
variable "db_name" { type = string }
variable "username" { type = string }
variable "password" { type = string, sensitive = true }
```

**Outputs:**
```hcl
output "db_endpoint" { value = aws_db_instance.main.endpoint }
output "db_port" { value = aws_db_instance.main.port }
output "db_username" { value = aws_db_instance.main.username }
```

### S3 Module (s3/)

**Purpose:** Creates storage buckets for logs and backups

**Resources:**
- S3 Buckets
- Bucket Versioning
- Bucket Encryption
- Lifecycle Rules
- Access Policies
- CloudFront Distribution (optional)

**Variables:**
```hcl
variable "bucket_name" { type = string }
variable "enable_versioning" { type = bool }
variable "lifecycle_days" { type = number }
```

**Outputs:**
```hcl
output "bucket_id" { value = aws_s3_bucket.main.id }
output "bucket_arn" { value = aws_s3_bucket.main.arn }
output "bucket_region" { value = aws_s3_bucket.main.region }
```

---

## 🔄 Managing Infrastructure

### Update Configuration

1. Modify the Terraform files
2. Run `terraform plan` to review changes
3. Run `terraform apply` to apply changes

```bash
terraform plan -out=tfplan
terraform apply tfplan
```

### Destroy Infrastructure

⚠️ **WARNING:** This will delete all resources and data!

```bash
terraform destroy
```

Or destroy specific resources:

```bash
terraform destroy -target=aws_eks_cluster.main
```

### Import Existing Resources

If you have existing AWS resources:

```bash
terraform import aws_eks_cluster.main flight-eks-cluster
```

### View State

```bash
# List resources in state
terraform state list

# Show specific resource
terraform state show aws_eks_cluster.main

# Backup state file
terraform state pull > backup.tfstate
```

---

## 📊 Monitoring

### CloudWatch Metrics

Monitor cluster health:

```bash
# View cluster metrics
aws cloudwatch get-metric-statistics \
  --namespace AWS/EKS \
  --metric-name node_cpu_usage \
  --dimensions Name=ClusterName,Value=flight-eks-cluster \
  --start-time 2024-01-01T00:00:00Z \
  --end-time 2024-01-02T00:00:00Z \
  --period 300 \
  --statistics Average
```

### RDS Monitoring

```bash
# Monitor database
aws rds describe-db-instances \
  --db-instance-identifier flightdb \
  --query 'DBInstances[0].[DBInstanceStatus,AllocatedStorage]'
```

### Kubernetes Monitoring

```bash
# View nodes
kubectl get nodes

# View pods in all namespaces
kubectl get pods --all-namespaces

# View resource usage
kubectl top nodes
kubectl top pods
```

---

## 🔧 Troubleshooting

### Common Issues

**1. Terraform State Lock:**
```bash
# Force unlock (use with caution)
terraform force-unlock <LOCK_ID>
```

**2. Insufficient Permissions:**
- Check AWS IAM permissions
- Ensure credentials have access to required services
- Review IAM role policies

**3. EKS Cluster Not Accessible:**
```bash
# Update kubeconfig
aws eks update-kubeconfig --region us-east-1 --name flight-eks-cluster

# Test connection
kubectl cluster-info
```

**4. RDS Connection Issues:**
```bash
# Check security group rules
aws ec2 describe-security-groups --filters Name=group-name,Values=flight-rds-sg

# Test connectivity
mysql -h <rds-endpoint> -u admin -p
```

### Debugging

Enable verbose logging:

```bash
export TF_LOG=DEBUG
terraform apply

# Disable
unset TF_LOG
```

---

## 💰 Cost Estimation

Use Terraform cost estimation tools:

```bash
# Estimate costs
terraform plan -json | jq '.resource_changes[] | select(.change.actions | index("create") > -1 or index("update") > -1)'

# Use Infracost for detailed cost analysis
infracost breakdown --path .
```

### Typical Monthly Costs (Rough Estimate)
- **EKS Cluster**: ~$73 (cluster fee)
- **EC2 Instances (2x t3.medium)**: ~$40-60
- **RDS Database (t3.micro)**: ~$30-50
- **S3 Storage & Requests**: ~$10-20
- **Data Transfer**: ~$5-10
- **Total**: **~$160-210/month**

---

## 🔐 Security Best Practices

1. **State Management**
   - Use Terraform Cloud/Enterprise for remote state
   - Enable state locking
   - Encrypt state files

2. **Secrets Management**
   - Use AWS Secrets Manager for passwords
   - Never commit `terraform.tfvars` with secrets
   - Use `terraform.tfvars.local` pattern

3. **IAM**
   - Use least privilege principles
   - Create separate IAM users for different environments
   - Enable MFA for AWS console access

4. **Network Security**
   - Use security groups to restrict access
   - Enable VPC Flow Logs
   - Use Network ACLs for additional layer

5. **Encryption**
   - Enable S3 bucket encryption
   - Use RDS encryption
   - Enable EBS volume encryption

---

## 📚 Additional Resources

- [Terraform Documentation](https://www.terraform.io/docs)
- [AWS Terraform Provider](https://registry.terraform.io/providers/hashicorp/aws/latest)
- [Kubernetes on AWS](https://kubernetes.io/docs/setup/production-environment/container-runtimes/containerd/)
- [AWS Well-Architected Framework](https://aws.amazon.com/architecture/well-architected/)

---

## 🤝 Contributing

1. Test changes in dev environment first
2. Document any new variables or outputs
3. Update this README with new features
4. Review Terraform plan before applying

---

**Last Updated:** March 2026  
**Version:** 1.0.0
**Terraform Version Required:** >= 1.0