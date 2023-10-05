import java.util.List;
import java.util.ArrayList;

public class Cellphone implements Runnable {

    private List<Address> addressBook;
    private List<Message> messages;

    private String phoneNumber;
    private Address address;

    private Message transferMessage;
    private Cellphone transferCellphone;

    public Cellphone(String phoneNumber, String name, String company) {
        if (!phoneNumber.matches("\\d{3}-\\d{4}-\\d{4}"))
            throw new IllegalArgumentException("전화번호 형식이 잘못되었습니다.");
        this.phoneNumber = phoneNumber;
        this.address = new Address(phoneNumber, name, company);
        addressBook = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public Cellphone(String phoneNumber) {
        this(phoneNumber, "", "");
    }

    public void send(Message message, Cellphone cellphone) {
        this.transferMessage = message;
        this.transferCellphone = cellphone;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        transferCellphone.receive(transferMessage, getAddress());
    }

    public void receive(Message message, Address address) {
        if (message.getPhoneNumber().equals(this.phoneNumber)) {
            messages.add(message);
            addressBook.add(address);
        } else {
            throw new IllegalArgumentException("receive : 수신이 잘못되었습니다.");
        }
    }

    public void readMessages() {
        for (int i = 0; i < messages.size(); i++) {
            System.out.println(messages.get(i));
        }
    }

    public void readAddressbook() {
        for (Address address : addressBook) {
            System.out.println(address);
        }

    }

    public Address getAddress() {
        return this.address;
    }

}