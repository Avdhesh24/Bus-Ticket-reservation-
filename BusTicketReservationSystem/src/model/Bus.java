package model;

public class Bus {
        private int busNo;
        private String busName;
        private String source;
        private String destination;
        private String departureTime;
        private String arrivalTime;
        private int totalSeats;
        private int availableSeats;
        private int totalFare;

        public Bus(int busNo, String busName, String source, String destination, String departureTime, String arrivalTime, int totalSeats, int availableSeats, int totalFare) {
                this.busNo = busNo;
                this.busName = busName;
                this.source = source;
                this.destination = destination;
                this.departureTime = departureTime;
                this.arrivalTime = arrivalTime;
                this.totalSeats = totalSeats;
                this.availableSeats = availableSeats;
                this.totalFare = totalFare;
        }

        // Getters and Setters
        public int getBusNo() {
                return busNo;
        }

        public void setBusNo(int busNo) {
                this.busNo = busNo;
        }

        public String getBusName() {
                return busName;
        }

        public void setBusName(String busName) {
                this.busName = busName;
        }

        public String getSource() {
                return source;
        }

        public void setSource(String source) {
                this.source = source;
        }

        public String getDestination() {
                return destination;
        }

        public void setDestination(String destination) {
                this.destination = destination;
        }

        public String getDepartureTime() {
                return departureTime;
        }

        public void setDepartureTime(String departureTime) {
                this.departureTime = departureTime;
        }

        public String getArrivalTime() {
                return arrivalTime;
        }

        public void setArrivalTime(String arrivalTime) {
                this.arrivalTime = arrivalTime;
        }

        public int getTotalSeats() {
                return totalSeats;
        }

        public void setTotalSeats(int totalSeats) {
                this.totalSeats = totalSeats;
        }

        public int getAvailableSeats() {
                return availableSeats;
        }

        public void setAvailableSeats(int availableSeats) {
                this.availableSeats = availableSeats;
        }

        public int getTotalFare() {
                return totalFare;
        }

        public void setTotalFare(int totalFare) {
                this.totalFare = totalFare;
        }

        @Override
        public String toString() {
                return "Bus [busNo=" + busNo + ", busName=" + busName + ", source=" + source + ", destination=" + destination
                        + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", totalSeats=" + totalSeats
                        + ", availableSeats=" + availableSeats + ", totalFare=" + totalFare + "]";
        }
}

