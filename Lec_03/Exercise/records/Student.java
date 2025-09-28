public record Student(String name, int facultyNumber) {

    //this is the compact constructor, no need to add () since the compiler adds this code
    //in the cannonical constructor before assaignments to the datamembers
    public Student {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Student's name is blank");
        }

        if (facultyNumber < 0) {
            throw new IllegalArgumentException("Faculty number is negative");
        }
    }

    //No need to explicitly code field assignments
    //These assignments are done by the implicit cannonical constructor
}