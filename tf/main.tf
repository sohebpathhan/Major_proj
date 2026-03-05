provider "aws" {
    region = "us-east-2"
}

module "rds" {
    source = "./modules/rds"
}

module "eks" {
    source = "./modules/eks"
    project = "pro"
    desired_nodes = 2
    max_nodes  = 2
    min_nodes  = 2
    node_instance_type = "c7i-flex.large"
}

module "s3" {
    source = "./modules/s3"
}