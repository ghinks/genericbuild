def call(Map config=[:]){
node {
    stage('SCM') {
    	echo 'Gathering code from version control'
	git branch: '${branch}', url: 'https://github.com/ghinks/JenkinsGroovy.git'
    }
    stage('Build') {
	try{
	        echo 'Building....'
//    		sh "dotnet build " + config.target
	        echo 'Building New Feature'
//		releasenotes(changes:"true")
        }catch(ex){
        	echo 'Something went wrong'
        	echo ex.toString();
        	currentBuild.result = 'FAILURE'
        }
        finally{
        	// cleanup
        }
    }
    stage('Test') {
        echo 'Testing....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}
}