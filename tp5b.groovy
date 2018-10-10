node {
    stage ('one'){
        echo "kikou"
        echo "joli"
    }
    stage ('two'){
        echo "kikou"
        echo "joli"
    }
     stage ('tree'){
        echo "hostname"
         echo "hostname $env.NOM_VAR"
    }
stage('Stage avec variable') {
withEnv([
"ENV_VARIABLE_NAME='value'",
"MODE_DEBUG=true",
]){
// Block de code qui peut
// utiliser ces variables
sh 'env'
}
}

}
