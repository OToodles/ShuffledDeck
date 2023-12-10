package theDeck;

import javax.swing.JOptionPane;

public class TheDeck
{
	public TheDeck()
	{
		String[] theDeck = null;

		theDeck = initializeDeck(theDeck);
		// lookAtTheDeckOfCards(theDeck);
		theDeck = assignNumbersToCards(theDeck);
		// lookAtTheDeckOfCards(theDeck);
		theDeck = assignPicturesToCards(theDeck);
		// lookAtTheDeckOfCards(theDeck);
		theDeck = assignSuitsToCards(theDeck);
		lookAtTheDeckOfCards(theDeck);
		shuffleDeck(theDeck);
		lookAtTheDeckOfCards(theDeck);
	}

	public String[] initializeDeck(String[] theDeck)
	{
		theDeck = new String[52];

		return theDeck;
	}

	public String[] assignNumbersToCards(String[] theDeck)
	{
		for (int n = 0, m = 0; n < theDeck.length; n++, m++)
		{
			if (m == 13)
			{
				m = 0;
			}

			theDeck[n] = String.valueOf(m);
		}

		return theDeck;
	}

	public String[] assignSuitsToCards(String[] theDeck)
	{
		for (int n = 0; n < theDeck.length; n++)
		{
			switch (n / 13)
			{
			case 0:
				theDeck[n] += " clubs";
				break;
			case 1:
				theDeck[n] += " diamonds";
				break;
			case 2:
				theDeck[n] += " hearts";
				break;
			default:
				theDeck[n] += " spades";
				break;
			}
		}

		return theDeck;
	}

	public String[] assignPicturesToCards(String[] theDeck)
	{
		for (int n = 0; n < theDeck.length; n++)
		{
			switch (Integer.parseInt(theDeck[n]))
			{
			case 0:
				theDeck[n] = "ace";
				break;
			case 10:
				theDeck[n] = "jack";
				break;
			case 11:
				theDeck[n] = "queen";
				break;
			case 12:
				theDeck[n] = "king";
				break;
			default:
				theDeck[n] = String.valueOf(Integer.parseInt(theDeck[n]) + 1);
				break;
			}
		}

		return theDeck;
	}

	public void lookAtTheDeckOfCards(String[] theDeck)
	{
		String outputString = "";

		for (int n = 0; n < theDeck.length; n++)
		{
			if (n % 13 == 0)
			{
				outputString += "\n";
			}

			outputString += theDeck[n] + ", ";
		}

		JOptionPane.showMessageDialog(null, outputString);
	}

	public void shuffleDeck(String[] theDeck)
	{
		int deckSize = theDeck.length;

		for (int i = deckSize - 1; i > 0; i--)
		{
			int j = (int) (Math.random() * (i + 1));

			String temp = theDeck[i];
			theDeck[i] = theDeck[j];
			theDeck[j] = temp;
		}
	}
}