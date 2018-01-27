package pe.gob.sunat.recaudacion2.tributaria.devolucion.utils;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListExtended<E> extends ArrayList<E> {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Override
   public boolean addAll(Collection<? extends E> c) {
      if(c==null)
         return true;
      return super.addAll(c);
   }
   
   @Override
   public boolean add(E e) {
      if(e==null)
         return true;
      return super.add(e);
   }
}
