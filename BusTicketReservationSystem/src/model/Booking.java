package model;

public class Booking {

        private int bookingId;
        private int userid;
        private int busNo;
        private int seatForm;
        private int seatTo;
        private boolean status;

        public Booking(int bookingId, int userid, int busNo, int seatForm, int seatTo, boolean status) {

               this.bookingId = bookingId;
               this.userid = userid;
               this.busNo = busNo;
               this.seatForm = seatForm;
               this.seatTo = seatTo;
               this.status = status;

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getSeatForm() {
        return seatForm;
    }

    public void setSeatForm(int seatForm) {
        this.seatForm = seatForm;
    }

    public int getSeatTo() {
        return seatTo;
    }

    public void setSeatTo(int seatTo) {
        this.seatTo = seatTo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", userid=" + userid + ", busNo=" + busNo + ", seatForm=" + seatForm + ", seatTo=" + seatTo +
                ", status=" + status + '}';
    }
}

