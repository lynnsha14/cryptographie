
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Cesar {
	
	private Map<String,String> shift;//declaration de la map
	private List<String>alphabet;// declaration liste
	
    public Cesar()
    {
    shift=new HashMap<>(); //initialisation
    alphabet = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q");
    }
    public void correspondace()
    { 
	for( int i =0; i<alphabet.size(); i++) //parcour de la liste
	{
	String ciphertext=alphabet.get(i); //je recupère le caractère a l'indice i
	String plaintext=alphabet.get((i+3) % 26) ; // je recupere le caratere apès avoir effectué l'operation        
	
	shift.put(ciphertext,plaintext);//ajout clé valeur
	}
	System.out.println("shift map:" + shift);
	}
    
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i=0;i<message.length();i++) {
        	 char c = message.charAt(i);//recupere le caractere a la position i
            String character = String.valueOf(c);//convertie le krtere en une chaine
            if (shift.containsKey(character)) {//verifie si le caractere est dans la map
                encryptedMessage.append(shift.get(character));//ajoute le caractre chiffé a la chaine
            } else {
                encryptedMessage.append(c);//sinon ajouter le caracte identiq
                
            }
        }
        return encryptedMessage.toString();
    }

    
    public String decrypt(String encryptedMessage)//je prends en paramètre le message crypté {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i=0; i < encryptedMessage.length();i++ )
        		{
           char c = encryptedMessage.charAt(i);
           String character=String.valueOf(c);
            if (shift.containsValue(character)) {
                for (Map.Entry<String, String> entry : shift.entrySet()) 
                	/*je parcours ma map et teste si la valeur associée a la clé correspond a la chaine character
                	 * 
                	 */
                	
                {
                    if (entry.getValue().equals(character)) {
                        decryptedMessage.append(entry.getKey());
                        break;
                    }
                }
            } else {
                decryptedMessage.append(c);
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Cesar cesar = new Cesar();
        String messageInit = "viens";
        String encryptedMessage = cesar.encrypt(messageInit);
        String decryptedMessage = cesar.decrypt (messageInit);

        System.out.println("message init: " + messageInit);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
    
    
    
    	
    
    



