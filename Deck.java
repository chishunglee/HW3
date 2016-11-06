import java.util.ArrayList;
import java.util.Random;
public class Deck{
	private ArrayList<Card> cards;
	 private ArrayList<Card> usedCard;  //用過的
	 public int nUsed;  //幾張牌  
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard=new ArrayList<Card>(); 
		for(int g=0;g<nDeck;g++)
		{
			for (Card.Suit s:Card.Suit.values()) 
			{
				for(int y=1;y<14;y++)
				{
					Card card=new Card(s,y);
					cards.add(card);
				}
			}
			
		}
		
		shuffle();
	}	
	
	public void printDeck(){
		
		for(int i=0;i<cards.size();i++)
		{
		   Card x = cards.get(i);
		   x.printCard();
		} 

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	
	

	public void shuffle()
	{ 
	Random rand = new Random();
	int size=usedCard.size();
	for(int a=0;a<usedCard.size();a++)
	{
			Card onecard=usedCard.get(a);
			cards.add(onecard);
	}
		
	for(int i=0;i<size;i++)
	{
		usedCard.remove(0);	//清空用過的牌
	}
	nUsed=0;    
	for(int i=0;i<cards.size();i++)
	{
	int j = rand.nextInt(cards.size()); //random隨機抽取
	Card temp=cards.get(i);
	cards.set(i,cards.get(j));
	cards.set(j, temp);
	}
}
	public Card getOneCard()
	{
		
	if(cards.size()==0)	
	{
		shuffle();   //已空執行洗牌
	}
	
	
	Card oneCard=cards.get(0);	//取拿到的牌
	usedCard.add(oneCard);
	cards.remove(0);	        /*避免重複*/
	nUsed++;
	return oneCard;
	
}



}