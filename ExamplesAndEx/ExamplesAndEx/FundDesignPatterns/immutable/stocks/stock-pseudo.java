package immutable.stocks;
import java.util.*;
// WARNING: this is only guideline code, pseudo code,
// should not be used as is, may not even compile,
// it is here just to show the general idea!
class Stock {
	int m_minValue;
	int m_maxValue;
	int m_currValue;

	public Stock(int max,int cur,int min) {
	}
	public Stock setMin(int minValue) {
		return new Stock(m_maxValue, m_currValue, minValue);
	}
	public Stock setMax(int maxValue) {
		return new Stock(m_currValue, m_minValue, maxValue);
	}

}

class StockManager {
		HashMap stocks = new HashMap();

		StockManager() {
//				for (...)
					stocks.put("stock1",new Stock(12,3,4));
		}

		void replace(Stock newone) {
			// find the right place in hashmap
			stocks.put("key", newone);
		}

		Stock getStock(String key) {
			return (Stock)stocks.get(key);
		}
}

class Thread {

	public void run() {
			//temp.m_minValue=12; // atomic action

			StockManager sm1 = new StockManager();
			Stock temp = sm1.getStock("aname");
			temp = temp.setMin(100);
			temp = temp.setMax(200);
			sm1.replace(temp);  // atomic action

	}

}