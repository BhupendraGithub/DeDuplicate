package edu.learn.deduplicate;

/**
 * The GNU Licence
 * The Program get Non Duplicate numbers from Duplicate list 
 * Copyright (C) 2016  Bhupendra Nath

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DeDup {
	/**
	 * randomIntegers set of random generated numbers
	 */
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * getNonDuplicatedByJavaStream() method use the Java8 stream features with
	 * lamda expression. With java8 the code become enormously less and use of
	 * lambda expression has decreased the use of the anonymous code in the
	 * method.
	 * 
	 * @return
	 */
	public int[] getNonDuplicateArrayByJavaStream() {
		List<Integer> arrayList = Arrays.stream(randomIntegers).boxed().collect(Collectors.toList());
		return arrayList.stream().distinct().mapToInt(i -> i).toArray();
	}

	/**
	 * getNonDuplicatedByLinearSearch is method to get distinct numbers out of
	 * duplicate list. The method use Linear Search with notation of O(n). There
	 * is distinctively other search algorithms and each algorithm has its own
	 * consecutive order of search.
	 * 
	 * For example binary search required "order of sorting" as prerequisite before
	 * performing search over number list.
	 * 
	 * The method also maintains the order of the numbers in the list and
	 * preserves the sequence of the numbers. In other search algorithms like
	 * binary search/tree search distrupt the order of the list and also add
	 * additional step of sorting before doing the search over number list and
	 * increase the O notation from from O(n) to O(n log(n)) or O(n^2) based on
	 * sorting method used for binary search / tree Search.
	 * 
	 * @return int[]
	 */
	public int[] getNonDuplicateArrayByLinearSearch() {
		// TreeMap to store duplicate locations in array list.
		Map<Integer, Integer> duplicateMap = new TreeMap();
		for (int counter1 = 0; counter1 < randomIntegers.length; counter1++) {
			Iterator iter = duplicateMap.keySet().iterator();
			while (iter.hasNext()) {
				if ((counter1 == (int) iter.next()) && (counter1 != randomIntegers.length - 1)) {
					counter1++;
				}
			}
			for (int counter2 = counter1 + 1; counter2 < randomIntegers.length; counter2++) {
				if (randomIntegers[counter1] == randomIntegers[counter2]) {
					duplicateMap.put(counter2, randomIntegers[counter2]);
				}
			}
		}
		int markedDuplicate[] = duplicateMap.keySet().stream().mapToInt(i -> i).toArray();
		int nonDuplicateArray[] = new int[randomIntegers.length - markedDuplicate.length];
		for (int counter1 = 0, counter2 = 0, counter3 = 0; counter1 < randomIntegers.length; counter1++) {
			if (counter1 == markedDuplicate[counter2]) {
				counter2++;
			} else {
				nonDuplicateArray[counter3++] = randomIntegers[counter1];
			}
		}
		return nonDuplicateArray;
	}

	/**
	 * getNonDuplicateArrayBySet is method to get distinct numbers out of
	 * duplicate list through java Set. This use java HashSet and hashing
	 * mechanism to get distinct numbers.
	 * 
	 * @return int[]
	 */
	public int[] getNonDuplicateArrayBySet() {
		Set<Integer> nonDuplicateSet = new HashSet<Integer>(
				Arrays.stream(randomIntegers).boxed().collect(Collectors.toList()));
		int nonDuplicateArray[] = nonDuplicateSet.stream().mapToInt(i -> i).toArray();
		return nonDuplicateArray;
	}

	/**
	 * getNonDuplicateArrayBySort is method to get distinct numbers out of
	 * duplicate list through Sort. This use Java 8 through stream sort
	 * then removing duplicate numbers.
	 * 
	 * @return int[]
	 */

	public int[] getNonDuplicateArrayBySort() {
		int tempRandomIntegers[] = Arrays.stream(randomIntegers).sorted().toArray();
		List<Integer> nonDuplicatedList = new ArrayList<Integer>();
		int tempDuplicateValue = tempRandomIntegers[0];
		nonDuplicatedList.add(tempDuplicateValue);
		for (int counter1 = 1; counter1 < tempRandomIntegers.length; counter1++) {
			if (tempDuplicateValue != tempRandomIntegers[counter1]) {
				tempDuplicateValue = tempRandomIntegers[counter1];
				nonDuplicatedList.add(tempDuplicateValue);
			}
		}

		int nonDuplicateArray[] = nonDuplicatedList.stream().mapToInt(i -> i).toArray();
		return nonDuplicateArray;
	}

	public static void main(String[] args) {
		DeDup deDup = new DeDup();
		System.out.println(Arrays.toString(deDup.getNonDuplicateArrayByJavaStream()) + " >> BY JAVA 8 STREAM");
		System.out.println(Arrays.toString(deDup.getNonDuplicateArrayByLinearSearch()) + " >> BY LINEAR SEARCH");
		System.out.println(Arrays.toString(deDup.getNonDuplicateArrayBySet()) + " >> BY SET");
		System.out.println(Arrays.toString(deDup.getNonDuplicateArrayBySort()) + " >> BY SORT");

	}
}
