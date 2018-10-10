@Library("libraries/mylib") _

node {

  stage('Gestion erreur'){

    println "Commande avant le try/catch"
    try {

      println "Commande pouvant générer une erreur"
      def number = env.BUILD_NUMBER as Integer

      if (number%2) {
        println "Number " + number +  " is impair"
        // levee une exception
        throw new Exception()
      }
      else { 
        notify('SUCCES')
      }

    } catch (Exception e) {
        notify('FAILED')
    } finally {
        println "Commande toujours exécutée"
    }
  }

  stage('End'){ println 'END'}
}
