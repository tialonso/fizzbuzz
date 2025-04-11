pipeline{
    agent any

    environment{
        REMOTE_HOST= "ec2-user@18.212.72.44"
        PEM_PATH= "/.ssh-keys/docker-vm2-keys.pem"
        REPO_URL="https://github.com/tialonso/fizzbuzz"
        REPOS_DIR = "/home/ec2-user/github-repos"
        FIZZBUZZ_DIR= "/home/ec2-user/github-repos/fizzbuzz"
    }

    stages{
        stage("limpieza"){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso1: LIMPIEZA"
                        sudo rm -rf $FIZZBUZZ_DIR
                        sudo mkdir -p $REPOS_DIR
                        exit
                    EOF
                """
            }
        }

        stage("clonado"){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso2: CLONADO DE REPO"
                        cd $REPOS_DIR
                        sudo git clone $REPO_URL
                        exit
                    EOF
                """
            }
        }

        stage("build"){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso3: Creación de imagen"
                        cd $FIZZBUZZ_DIR
                        sudo docker build -t multi-image .
                        exit
                    EOF
                """
            }
        }

        stage("ejecución"){
            steps{
                sh """
                    sudo ssh -i $PEM_PATH $REMOTE_HOST << EOF
                        echo "Paso4: Ejecución de imagen... correr contenedor"
                        sudo docker rm -f multi-1 || true
                        sudo docker run --name multi-1 -d -p 8090:8080 multi-image
                        exit
                    EOF
                """
            }
        }

    }
}