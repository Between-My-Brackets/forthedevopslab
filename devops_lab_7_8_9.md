# DevOps Lab – Programs 7, 8, 9 (Jenkins Pipelines)

---

# ✅ PROGRAM 7 – Jenkins CI Pipeline

## Aim
To create a Jenkins CI pipeline to build a Maven project.

---

## Prerequisites
- Jenkins installed and running
- Maven configured in Jenkins (Manage Jenkins → Tools)
- GitHub access

---

## Steps to Execute

1. Open Jenkins:
   http://localhost:8080

2. Create Pipeline Job:
   - Click New Item
   - Name: Program7-CI
   - Select Pipeline
   - Click OK

3. Configure Maven:
   - Manage Jenkins → Tools
   - Add Maven → Name: Maven → Install Automatically → Save

4. Add Pipeline Script

5. Click Build Now

---

## Jenkins Pipeline Script

```
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/girishchandra-atvisai/DevOps.git'
            }
        }

        stage('Build') {
            steps {
                dir('Lab-01-Maven/aut-app') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo 'Build Successful'
        }
    }
}
```

---

## Commands Used
mvn clean package -DskipTests

---

## Output
- BUILD SUCCESS
- JAR file created in target folder

---

## Result
CI pipeline executed successfully.

---

# ✅ PROGRAM 8 – Jenkins Artifact Archiving

## Aim
To archive build artifacts (.jar file) in Jenkins.

---

## Steps to Execute

1. Create new pipeline job:
   - Name: Program8-Artifact

2. Add pipeline script

3. Click Build Now

4. Check Artifacts section

---

## Jenkins Pipeline Script

```
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/girishchandra-atvisai/DevOps.git'
            }
        }

        stage('Build') {
            steps {
                dir('Lab-01-Maven/aut-app') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'Lab-01-Maven/aut-app/target/*.jar', fingerprint: true
        }
    }
}
```

---

## Commands Used
mvn clean package -DskipTests

---

## Output
- BUILD SUCCESS
- Artifact visible in Jenkins

---

## Result
Artifact archived successfully.

---

# ✅ PROGRAM 9 – Parameterized Jenkins Pipeline

## Aim
To create a parameterized Jenkins pipeline.

---

## Steps to Execute

1. Create new pipeline job:
   - Name: Program9-Parameterized

2. Add pipeline script

3. Click Build with Parameters

4. Enter BRANCH_NAME = main

---

## Jenkins Pipeline Script

```

pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    parameters {
        string(name: 'new_branch', defaultValue: 'main', description: 'Git branch to build')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: params.new_branch, url: 'https://github.com/Between-My-Brackets/forthedevopslab'
            }
        }

        stage('Build') {
            steps {
                dir('Lab-01-Maven/aut-app') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
    }
}

```

---

## Commands Used
mvn clean package -DskipTests

---

## Output
- BUILD SUCCESS

---

## Result
Parameterized pipeline executed successfully.

---

# FINAL SUMMARY

Program 7: CI Pipeline  
Program 8: Artifact Archiving  
Program 9: Parameterized Pipeline  

All programs executed successfully.
