(ns twchomework.core
	(:require [clojure.set]))

(defn -check-possible [side1 side2 side3]
	(let [sorted-list (sort > (conj nil side1 side2 side3))]
		(< (first sorted-list) (reduce + (rest sorted-list)))
	)
)

(defn classify-triangle [side1 side2 side3]
	(if (-check-possible side1 side2 side3)
		(let [same-sides (count (distinct (conj nil side1 side2 side3)))]
			(cond 
				(= 3 same-sides) "Scalene"
				(= 2 same-sides) "Isosceles"
				:else "Equilateral"
				)

			)
		nil
	)
)

(defn get-5th-element-from-last [examplelist]
	"for each item in list,
	if vector count is 5, take rest,
	push list-item to vector,
	at end of list, return first item in vector,
	return nil for when lists arent even 5 items long.
	"
	(loop [looplist examplelist itemholder []]
		(if (empty? looplist)
			(if (< (count itemholder) 5)
				nil
				(first itemholder)
			)
			(if (= 5 (count itemholder))
				(recur (rest looplist) (conj (vec (rest itemholder)) (first looplist)))
				(recur (rest looplist) (conj (vec itemholder) (first looplist)))
			)
		)
	)	
)

(defn all-items-in-list1-are-in-list2? [list1 list2]
	(if (= (count (set list1)) (count (clojure.set/intersection (set list1) (set list2))))
		true
		false
	)
)

