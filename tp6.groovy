//
// 1 - Variable d'environnement
//
node {

  stage('0- clean'){
    deleteDir()
    checkout scm
  }

  stage ('1- Print Jenskins variables'){
    echo "$env.NOM_VAR"
  }
  stage ('1- Print all env'){
    withEnv([
            "ENV_VARIABLE_NAME='value'",
            "MODE_DEBUG=true",
          ]){
// Block de code qui peut
// utiliser ces variables
            echo 'Affiche toutes les variables environnement disponibles :'
    sh 'env'
  }
  }           

    
}// fin node

//
// 2 - Paramètres utilisateurs du script
//

node {
  stage('2- Print parameter'){
    sh 'echo $Param_tp6'
  

    // Pour récupérer la valeur dans le script
    def value = params.Param_tp6
    def value_upper = params.Param_tp6.toUpperCase()

    println "Print default => " + params.Param_tp6
    println "Print default => " + value
    println "Print upper case value =>  + value_upper"

  }
}

//
// 3 - Credentials
//

node {
  stage('3- Récupération des crédentials'){
    withCredentials([
      usernamePassword(
          credentialsId: 'credential_login_GitHUB',
          usernameVariable: "DEMO_USERNAME",
          passwordVariable: "DEMO_PASS"
      ),
      file(
        credentialsId: 'secret_file',
        variable: 'SECRET_FILE')
    ]){

      // Affichage des variables :
 sh 'echo "usernameVariable $DEMO_USERNAME"'
       sh 'echo "passwordVariable $DEMO_PASS"'
       sh 'echo "usernameVariable $SECRET_FILE"'
    }
  } // end withCredential, les variables ne sont plus accessibles après
}

