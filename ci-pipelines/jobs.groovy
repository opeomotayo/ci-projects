// github('opeomotayo/cd-projects') can also be used instead of url('https://github.com/opeomotayo/cd-projects.git')
// multiple pipelinesJobs can also be set here
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
      scriptPath('ci-pipelines/actions-controller/Jenkinsfile')
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
      scriptPath('ci-pipelines/todo-ci/Jenkinsfile')
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
      scriptPath('technologies/cd-pipelines/todo-cd/Jenkinsfile')
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
      scriptPath('ci-pipelines/flask-blog-ci/Jenkinsfile')
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
      scriptPath('technologies/cd-pipelines/flask-blog-cd/Jenkinsfile')
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
      scriptPath('ci-pipelines/html-blog-ci/Jenkinsfile')
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
      scriptPath('technologies/cd-pipelines/html-blog-cd/Jenkinsfile')
    }  
  }       
}

pipelineJob('bookstore-ci') {
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
      scriptPath('ci-pipelines/bookstore-ci/Jenkinsfile')
    }  
  }       
}
pipelineJob('bookstore-cd') {
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
      scriptPath('technologies/cd-pipelines/bookstore-cd/Jenkinsfile')
    }  
  }       
}