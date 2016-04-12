package spring.profilebeans;


public class DevelopDataSource implements DataSource {

    @Override
    public String getConnString() {
        return "develop localhost";
    }
}
