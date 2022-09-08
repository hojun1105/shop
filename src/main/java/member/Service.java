package member;

public class Service {
    private Dao dao;

    public Service(){
        dao = new Dao();
    }
    public void join(Member m){
       dao.insert(m);
    }
    public Member getMember(String id){
        return dao.select(id);
    }

    public void editMember(Member m){
        dao.update(m);
    }
    public void deleteMember(String id){
        dao.delete(id);
    }
}
