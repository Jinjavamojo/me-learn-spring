package spring.profilebeans;


public class ProdDataSource implements DataSource {

    @Override
    public String getConnString() {
        return "real 146% address. i swear";
    }
}
