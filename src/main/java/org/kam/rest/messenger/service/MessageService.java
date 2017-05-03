package org.kam.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kam.rest.messenger.database.DatabaseClass;
import org.kam.rest.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService(){
		messages.put(1L, new Message(1, "Message 1", "Kamlesh"));
		messages.put(2L, new Message(2, "Message 2", "Doug"));
		messages.put(3L, new Message(3, "Message 3", "Janet"));
		messages.put(4L, new Message(4, "Message 4", "Ravi"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
		
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if (message.getId() <= 0)
		{
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);		
	}
}
