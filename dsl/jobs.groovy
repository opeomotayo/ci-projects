// github('opeomotayo/cd-projects') can also be used instead of url('https://github.com/opeomotayo/cd-projects.git')
// multiple pipelinesJobs can also be set here
pipelineJob('hello-world') {
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
        scriptPath('flask-applications/helloworld/Jenkinsfile')
        }  
    }       
}
pipelineJob('actions-controller2') {
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
        scriptPath('dsl/pipelines/actions-controller/Jenkinsfile')
        }  
    }       
}