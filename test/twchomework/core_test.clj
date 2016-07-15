(ns twchomework.core-test
  (:require [clojure.test :refer :all]
            [twchomework.core :refer :all]))

(deftest test-classify-triangle
  (testing "identifies an equaliteral"
    (is (= "Equilateral" (classify-triangle 2 2 2)))
    )
  (testing "identifies an Isosceles"
    (is (= "Isosceles" (classify-triangle 2 2 3)))
    )
  
(testing "identifies a Scalene"
    (is (= "Scalene" (classify-triangle 3 4 5)))
    )
(testing "Not a possible triangle, meaningless input returns nil"
    (is (= nil (classify-triangle 10 6 4)))
    )
)
  
(deftest test-get-5th-element-from-last
	(testing "gets 5th from last element"
	    (is (= 6 (get-5th-element-from-last '(1 2 3 4 5 6 7 8 9 0)))
	    )
	)
	(testing "returns nil for when there are less than 5 elements"
	    (is (= nil (get-5th-element-from-last '(1 2 3)))
	    )
	)
)

(deftest test-all-items-in-list1-are-in-list2?
	(testing "when lists are same length, no dupes"
	    (is (all-items-in-list1-are-in-list2? '(1 2 3) '(1 2 3))
	    )
	)
	(testing "when lists are same length, with dupes"
	    (is (all-items-in-list1-are-in-list2? '(1 1 1) '(1 2 3))
	    )
	)
	(testing "when lists are different lengths, no dupes"
	    (is (all-items-in-list1-are-in-list2? '(1 2 3) '(1 2 3 4 5 6))
	    )
	)
	(testing "when lists are different lengths, with dupes"
	    (is (all-items-in-list1-are-in-list2? '(1 2 3 3 3) '(1 2 3 3 4 5 6))
	    )
	)
	(testing "should be false when not all items are in second list"
	    (is (not (all-items-in-list1-are-in-list2? '(1 2 3) '(1 2 4)))
	    )
	)
	(testing "should be false when not all items are in second list, dupes"
	    (is (not (all-items-in-list1-are-in-list2? '(1 2 2) '(1 3 3)))
	    )
	)
	(testing "should be false when not all items are in second list, different lengths, no dupes"
	    (is (not (all-items-in-list1-are-in-list2? '(1 2 3) '(2 3 4 5 6 7)))
	    )
	)
	(testing "should be false when not all items are in second list, different lengths, with dupes"
	    (is (not (all-items-in-list1-are-in-list2? '(1 2 3 3 3 3) '(2 3 3 3 4 5 6 7)))
	    )
	)
)
	
