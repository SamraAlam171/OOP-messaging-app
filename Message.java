import java.time.LocalDateTime;

public class Message{
    private String sender;
    private String receiver;
    private String messageContent;
    private LocalDateTime timeStamp;
    private boolean status;
    private String messageId;
    private static int counter = 1;

    public Message(String sender, String receiver,String messageContent, boolean status, String messageId){
        this.sender = sender;
        this.receiver = receiver;
        this.messageContent = messageContent;
        this.status = status;
        messageId = String.format("%03d", counter++);
        this.timeStamp = LocalDateTime.now();
    }

    public Message(String sender, String receiver,String messageContent, boolean status){
        this.sender = sender;
        this.receiver = receiver;
        this.messageContent = messageContent;
        this.status = status;
        this.messageId = String.format("%03d", counter++); 
        this.timeStamp = LocalDateTime.now();
    }

    public String getSender(){
        return sender;
    }

    public String getReceiver(){
        return receiver;
    }
    
    public String getMessageContent(){
        return  messageContent;
    }

    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status =  status;
    }

    public LocalDateTime getTimestamp() {
        return timeStamp;
    }

    public String getMessageId() {
        return messageId;
    }

    @Override
    public String toString(){
        return String.format("%s, %s, %s, %b, %s, %s", sender, receiver, messageContent, status, messageId, timeStamp);
    }
}