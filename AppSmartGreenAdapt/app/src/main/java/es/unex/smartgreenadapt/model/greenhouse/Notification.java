package es.unex.smartgreenadapt.model.greenhouse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Notification {

    @SerializedName("message")
    public ArrayList<MessageNotification> message = new ArrayList<>();

    public ArrayList<MessageNotification> getList() {
        return message;
    }

    public void setList(ArrayList<MessageNotification> message) {
        this.message = message;
    }

    public void addMessage(MessageNotification message){ this.message.add(message);}
}

