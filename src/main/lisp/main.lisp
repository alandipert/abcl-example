(cl:in-package #:common-lisp-user)

(defpackage #:main
  (:use #:common-lisp #:java)
  (:export #:main))

(cl:in-package #:main)

(defun main (&rest args)
  (jcall "run" (jstatic "getInstance" "org.armedbear.lisp.Interpreter")))
