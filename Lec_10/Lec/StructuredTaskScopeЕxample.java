public String loadUserPage() {

    // тук се създава контейнера за задачите, когато този scope свърши scope автоматично ще се затвори 
    try(var scope = StructuredTaskScope.<String>open()) {

        // тук се стартират нови виртуални нишки веднага, но остават част от scope
        var userTask = scope.fork(() -> loadUser());
        var postsTask = scope.fork(() -> loadPosts());

        // главната точка на синхронизацията, главната нишка спира тук и чака и няма да продължи докато всички стартирани задачи в този scope не приключат
        scope.join()

        // Retrieve results
        return userTask.get() + ": " + postsTask.get();

    }  catch (StructuredTaskScope.FailedException | InterruptedException e) {
        throw new UserPageLoadException("Failed to load user page", e);
    }


}