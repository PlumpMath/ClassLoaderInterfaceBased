package about.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {

	public static void main(String[] args) {
		Map<String, Tab> tabs = new HashMap<String, Tab>();
		tabs.put("Portfolio", new Tab(3));
		tabs.put("Home", new Tab(1));
		tabs.put("Contatti", new Tab(4));
		tabs.put("Chi siamo", new Tab(2));

		System.out.println("------------Map non ordinata-----------");
		System.out.println("unsorted map: " + tabs);
		for (String key : tabs.keySet()) {
			System.out.println("tab: " + tabs.get(key).getPosition());
		}
		System.out.println("-----------------------------------\n");

		//Ordinamento
		tabs = sortTabs(tabs);

		System.out.println("------------Map ordinata-----------");
		System.out.println("sorted map: " + tabs);
		for (String key : tabs.keySet()) {
			System.out.println("tab: " + tabs.get(key).getPosition());
		}
		System.out.println("-----------------------------------");
		
	}

	public static Map<String, Tab> sortTabs(Map<String, Tab> tabs) {

		PositionComparator pc = new PositionComparator(tabs);
		TreeMap<String, Tab> sorted_map = new TreeMap<String, Tab>(pc);

		sorted_map.putAll(tabs);

		return sorted_map;
	}
}

class PositionComparator implements Comparator<String> {

	Map<String, Tab> unsortedMap;

	public PositionComparator(Map<String, Tab> unsortedMap) {
		this.unsortedMap = unsortedMap;
	}

	@Override
	public int compare(String a, String b) {
		if (unsortedMap.get(a).getPosition() < unsortedMap.get(b).getPosition()) {
			/* System.out.println(a +" e' prima di "+b);*/
			return -1;
		} else if (unsortedMap.get(a).getPosition() > unsortedMap.get(b)
				.getPosition()) {
			// System.out.println(a +" e' dopo di "+b);
			return 1;
		} else {
			return 0;
		}

	}
}
