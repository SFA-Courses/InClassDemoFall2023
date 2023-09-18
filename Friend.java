public class Friend {
    private String username;
    private boolean status;

    public Friend(String username, boolean status) {
        this.username = username;
        this.status = status;
    }

    public String getUsername() {
        return this.username;
    }

    public void setStatus(boolean newStatus) {
        this.status= newStatus;    
    }

    public boolean isOnline() {
        return this.status;
    }


    @Override
    public String toString() {
        String s = this.status ? "Online" : "Offline";
        return this.username + " " + s;
    }

}
