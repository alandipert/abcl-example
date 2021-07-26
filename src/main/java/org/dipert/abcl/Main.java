package org.dipert.abcl;

import org.armedbear.lisp.Cons;
import org.armedbear.lisp.Interpreter;
import org.armedbear.lisp.LispObject;
import org.armedbear.lisp.Load;
import org.armedbear.lisp.Nil;
import org.armedbear.lisp.Packages;
import org.armedbear.lisp.Symbol;

public class Main {
  public static LispObject argsToList(String[] args) {
    LispObject list = Nil.NIL;
    for (int i = args.length-1; i >= 0; i--)
      list = new Cons(args[i], list);
    return list;
  }
  public static void main(String[] args) {
    Interpreter.createInstance();
    Load.load(Main.class.getResourceAsStream("/main.lisp"));
    Symbol main = Packages.findPackage("MAIN").findAccessibleSymbol("MAIN");
    Symbol apply = Packages.findPackage("COMMON-LISP").findAccessibleSymbol("APPLY");
    apply.execute(main, argsToList(args));
  }
}
