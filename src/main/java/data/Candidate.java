package data;

public class Candidate implements Identifiable {
    int id;
    Vacancy vacancy;
    String name;
    String resume;

    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", vacancy=" + vacancy +
                ", name='" + name + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candidate candidate = (Candidate) o;

        if (id != candidate.id) return false;
        if (vacancy != null ? !vacancy.equals(candidate.vacancy) : candidate.vacancy != null) return false;
        if (name != null ? !name.equals(candidate.name) : candidate.name != null) return false;
        return !(resume != null ? !resume.equals(candidate.resume) : candidate.resume != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (vacancy != null ? vacancy.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (resume != null ? resume.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
