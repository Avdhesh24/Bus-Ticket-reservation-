package model;

public class User {

        private static int userid;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String address;
        private String mobile;

        // Constructor
        public User(int userid, String username, String password, String firstName, String lastName, String address, String mobile) {
                this.userid = userid;
                this.username = username;
                this.password = password;
                this.firstName = firstName;
                this.lastName = lastName;
                this.address = address;
                this.mobile = mobile;
        }

        // Getters and Setters
        public static int getUserid() {
                return userid;
        }

        public void setUserid(int userid) {
                this.userid = userid;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        @Override
        public String toString() {
                return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", firstName=" + firstName
                        + ", lastName=" + lastName + ", address=" + address + ", mobile=" + mobile + "]";
        }
}
