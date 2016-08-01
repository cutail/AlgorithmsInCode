;;; extended euclid algorithm
(defun euclid(m n)
  (and (integerp m) (integerp n)
       (cond ((zerop n) (list m 1 0))
	     (t (let ((tmp (euclid n (rem m n))))
		  (list (car tmp) (caddr tmp)
			(- (cadr tmp) (* (floor (/ m n)) (caddr tmp)))))))))

(defun divid?(m n)
  (and (integerp m) (integerp n)
       (zerop (rem n m))))

;; calculate the mod equation:  ax = b (mod n)
(defun mod-inverse(a b n)
  (let* ((enc (euclid a n))
	 (d (car enc)))
    (if (divid? d b)
	(let* ((res nil) (x0 (* (cadr enc) (/ b d))))
	  (dotimes (i d)
	    (push (mod (+ x0 (* i (/ n d)))
		       n) res)) res) nil)))


;; calculate: a^b mod n
(defun mod-exp(a b n)
  (and (integerp a) (integerp b) (integerp n) (> b 0) (> n 0)
       (let ((str (format nil "~b" b))
	     (res 1))
	 (dotimes (i (length str))
	   (setf res (mod (* res res) n))
	   (setf res (mod (* res
			     (if (= 1 (digit-char-p (char str i)))
				 a
				 1)) n)))
	 res)))
	 


  
