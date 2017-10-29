
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here B0544201 顾雨薇
 * Try to write some comments for your codes (methods, 15 points)
 * 先确定输入有几副牌（sc），将deck、card实体化，用三个for回圈的方式循环分别写出花色、大小、sc副牌并通过if print出来
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 所有的牌
	 * @param nDeck 總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);                                                                                                                              
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 * 第一个回圈代表有几副牌，第二个回圈代表花色，第三个回圈代表大小
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for (int deck=1;deck<=nDeck;deck++){//几副牌
			for(int suit=1;suit<=4;suit++){//花色
				for(int Rank=1;Rank<=13;Rank++){//大小
					Card card=new Card(suit,Rank);
					cards.add(card);//将新实体化的card加到清单（cards）里面
				}
			}
		}
		

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int n=0;
		while (cards.size()>n){
			Card card=new Card(cards.get(n).getSuit(),cards.get(n).getRank());
			card.printCard();//呼叫printcard
			n++;
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 * 将花色及大小编号（Clubs=1, Diamonds=2, Hearts=3, Spades=4）（rank 1-13）
 * 通过if 判断相应的花色和大小并print出来
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		if(suit==1)
			System.out.print("Clubs");
		if(suit==2)
			System.out.print("Diamonds");
		if(suit==3)
			System.out.print("Hearts");
		if(suit==4)
			System.out.print("Spades");
		if(rank==1)
			System.out.println("A");
		if(rank==2)
			System.out.println("2");
		if(rank==3)
			System.out.println("3");
		if(rank==4)
			System.out.println("4");
		if(rank==5)
			System.out.println("5");
		if(rank==6)
			System.out.println("6");
		if(rank==7)
			System.out.println("7");
		if(rank==8)
			System.out.println("8");
		if(rank==9)
			System.out.println("9");
		if(rank==10)
			System.out.println("10");
		if(rank==11)
			System.out.println("J");
		if(rank==12)
			System.out.println("Q");
		if(rank==13)
			System.out.println("K");
		
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}