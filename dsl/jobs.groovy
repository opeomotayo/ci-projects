// github('opeomotayo/cd-projects') can also be used instead of url('https://github.com/opeomotayo/cd-projects.git')
// multiple pipelinesJobs can also be set here
pipelineJob('flask-app1-build-image') {
    logRotator {
        numToKeep(10)
        daysToKeep(30)
    }
    definition {
        cpsScm {
        scm {
            git {
            remote {
                github('opeomotayo/ci-projects')
            }
            branches('main')
            }
        }   
        scriptPath('dsl/pipelines/flask-app1/Jenkinsfile')
        }  
    }       
}

pipelineJob('flask-app1-update-tag') {
    logRotator {
        numToKeep(10)
        daysToKeep(30)
    }
    definition {
        cpsScm {
        scm {
            git {
            remote {
                github('opeomotayo/cd-projects')
            }
            branches('main')
            }
        }   
        scriptPath('technologies/deployment-pipelines/Jenkinsfile')
        }  
    }       
}

pipelineJob('actions-controller') {
    logRotator {
        numToKeep(10)
        daysToKeep(30)
    }
    definition {
        cpsScm {
        scm {
            git {
            remote {
                github('opeomotayo/ci-projects')
            }
            branches('main')
            }
        }   
        scriptPath('dsl/pipelines/actions-controller/Jenkinsfile')
        }  
    }       
}