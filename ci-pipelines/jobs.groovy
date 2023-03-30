// github('opeomotayo/cd-projects') can also be used instead of url('https://github.com/opeomotayo/cd-projects.git')
// multiple pipelinesJobs can also be set here
pipelineJob('flask-app1-build-image') {
  logRotator {
    numToKeep(10)
    daysToKeep(30)
  }
  triggers {
    githubPush()
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

pipelineJob('java-app1-build-image') {
  logRotator {
    numToKeep(10)
    daysToKeep(30)
  }
  triggers {
    githubPush()
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
      scriptPath('dsl/pipelines/java-app1/Jenkinsfile')
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

pipelineJob('todo-ci') {
  logRotator {
    numToKeep(10)
    daysToKeep(30)
  }
  triggers {
    githubPush()
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
      scriptPath('dsl/pipelines/todo-ci/Jenkinsfile')
    }  
  }       
}
pipelineJob('todo-cd') {
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
      scriptPath('technologies/deployment-pipelines/todo-cd/Jenkinsfile')
    }  
  }       
}

pipelineJob('flask-blog-ci') {
  logRotator {
    numToKeep(10)
    daysToKeep(30)
  }
  triggers {
    githubPush()
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
      scriptPath('dsl/pipelines/flask-blog-ci/Jenkinsfile')
    }  
  }       
}
pipelineJob('flask-blog-cd') {
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
      scriptPath('technologies/deployment-pipelines/flask-blog-cd/Jenkinsfile')
    }  
  }       
}

pipelineJob('html-blog-ci') {
  logRotator {
    numToKeep(10)
    daysToKeep(30)
  }
  triggers {
    githubPush()
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
      scriptPath('dsl/pipelines/html-blog-ci/Jenkinsfile')
    }  
  }       
}
pipelineJob('html-blog-cd') {
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
      scriptPath('technologies/deployment-pipelines/html-blog-cd/Jenkinsfile')
    }  
  }       
}