import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class App{
Message messages[][];
Scanner scanner = new Scanner(System.in);
int senderIndex = 0;
int receiverIndex = 0;

    //initilazing constructor by 2D array
public App(){
        messages = new Message[100][100];
}

        // Menu to allow the user to choose options
        public void showMenu() {
            while (true) {
                System.out.println("\n----- Messaging App Menu -----");
                System.out.println("1. Send Message");
                System.out.println("2. Display Messages");
                System.out.println("3. Delete Message");
                System.out.println("4. Check Message Status");
                System.out.println("5. Search Message");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        sendMessage();
                        break;
                    case 2:
                        displayMessage();
                        break;
                    case 3:
                        deleteMessage();
                        break;

                    case 4:
                         checkStatus();
                         break;

                    case 5:
                        searchMessage();
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

    public void sendMessage(){
        String choice = "y";
        while(choice.equalsIgnoreCase("y")){
            System.out.println("Enter sender name: ");
            String sender = scanner.nextLine();
    
            System.out.println("Enter receiver name: ");
            String receiver = scanner.nextLine();
    
            System.out.println("Enter message content: ");
            String content = scanner.nextLine();
    
            if(senderIndex < 100 && receiverIndex < 100){
                messages[senderIndex][receiverIndex] = new Message(sender, receiver, content, false);
                receiverIndex++;
                if (receiverIndex == 100) {
                    senderIndex++;
                    receiverIndex = 0;
                }
                System.out.println("Do you wanna send another message?(y/n): ");
                choice = scanner.nextLine();
            } else{
                System.out.println("storage is full!");
                break;
            }
        }
    }

    public void displayMessage(){
        List<Message> messageList = new ArrayList<>();
        for(int i = 0; i <= senderIndex; i++){
            for(int j = 0; j <= receiverIndex; j++){
                if(messages[i][j] != null ){
                    messageList.add(messages[i][j]);
                }
            }
        }

        messageList.sort(Comparator.comparing(Message::getTimestamp));
        System.out.println("MESSAGE INFO: ");
        for(Message message : messageList ){
            System.out.println("Sender: " + message.getSender());
            System.out.println("Receiver: " + message.getReceiver());
            System.out.println("Content: " + message.getMessageContent());
            System.out.println("Timestamp: " + message.getTimestamp());
            System.out.println("-----------------------------");
        }
        }

    public void deleteMessage() {
        System.out.println("Enter the sender's name:");
        String sender = scanner.nextLine();
        System.out.println("Enter the receiver's name:");
        String receiver = scanner.nextLine();

    boolean messageFound = false;
        for (int i = 0; i <= senderIndex; i++) {
            for (int j = 0; j <= receiverIndex; j++) {
                if (messages[i][j] != null && messages[i][j].getSender().equals(sender) && messages[i][j].getReceiver().equals(receiver)) {
                    messages[i][j] = null; 
                    System.out.println("Message from " + sender + " to " + receiver + " deleted successfully!");
                    messageFound = true;
                    break; 
                }
            }
        if (messageFound) break; 
    }

    if (!messageFound) {
        System.out.println("No message found for the given sender and receiver.");
    }
}

    public void checkStatus() {
    System.out.println("Enter the sender's name:");
    String sender = scanner.nextLine();
    System.out.println("Enter the receiver's name:");
    String receiver = scanner.nextLine();

    boolean messageFound = false;
    for (int i = 0; i <= senderIndex; i++) {
        for (int j = 0; j <= receiverIndex; j++) {
            if (messages[i][j] != null && 
                messages[i][j].getSender().equals(sender) && 
                messages[i][j].getReceiver().equals(receiver)) {
                
                messageFound = true;
                if (messages[i][j].getStatus()) {
                    System.out.println("Message from " + sender + " to " + receiver + " has been seen.");
                } else {
                    System.out.println("Message from " + sender + " to " + receiver + " is unseen.");
                }
                break; 
            }
        }
        if (messageFound) break; 
    }
    if (!messageFound) {
        System.out.println("No message found for the given sender and receiver.");
    }
}


public void searchMessage() {
    System.out.println("Enter the sender's name:");
    String sender = scanner.nextLine();
    System.out.println("Enter the receiver's name:");
    String receiver = scanner.nextLine();

    boolean messageFound = false;

    System.out.println("Search results for messages from " + sender + " to " + receiver + ":");
    for (int i = 0; i <= senderIndex; i++) {
        for (int j = 0; j <= receiverIndex; j++) {
            if (messages[i][j] != null && 
                messages[i][j].getSender().equals(sender) && 
                messages[i][j].getReceiver().equals(receiver)) {
                
                System.out.println("Sender: " + messages[i][j].getSender());
                System.out.println("Receiver: " + messages[i][j].getReceiver());
                System.out.println("Content: " + messages[i][j].getMessageContent());
                System.out.println("Timestamp: " + messages[i][j].getTimestamp());
                System.out.println("-----------------------------");
                messageFound = true;
            }
        }
    }

    if (!messageFound) {
        System.out.println("No messages found for the given sender and receiver.");
    }
}

}

