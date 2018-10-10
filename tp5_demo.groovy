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
}
