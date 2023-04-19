package model;

public class PlayersList{

    private LinkedListPlayerNode head;

    //Methods

    public LinkedListPlayerNode searchPlayerByName(String name){
        return searchPlayerByName(name, head);
    }
    private LinkedListPlayerNode searchPlayerByName(String name, LinkedListPlayerNode current){
        if(current == null) return null;//Si no existe la cabeza, la lista está vacía y retorna null.
        if(current.getPlayer().getName().equals(name)) return current; //Si la encuentra, retorna el current.
        return searchPlayerByName(name, current.getNext()); //Si no lo encuentra, hace recursividad con el next.
    }

    public void add(LinkedListPlayerNode player){
        if(head == null){ //Si la cabeza es null, se agrega el nuevo jugador con el símbolo que haya elegido a la cabeza.
            head = player;
            head.setNext(head); //Se setean el siguiente y el anterior como la cabeza.
            head.setPrevious(head);
        }else{
            LinkedListPlayerNode tail = head.getPrevious();//Si la cabeza ya existe, se crea una cola y se iguala al previo de la head.
            player.setNext(head);//El siguiente del player a agregar será la head.
            head.setPrevious(player);//Se setea el previo de la cabeza como el player a agregar.
            tail.setNext(player);//Ahora el siguiente de la cola es el player a agregar.
            player.setPrevious(tail);//Ahora se setea el previo del player como la cola.
        }
    }

    public boolean checkIfPlayerExists(String name){
        if(head == null){
            return false;
        }
        if (head.getPlayer().getName().equals(name))
          return true;//Si la cabeza es el player que se busca, se retorna true.
        return checkIfPlayerExists(name, head.getNext());//Si no es así, se hace recursividad desde el siguiente de la cabeza.
    }

    private boolean checkIfPlayerExists(String name, LinkedListPlayerNode current){
        if(current == null) return false; //Si el siguiente (current) es null, retorna null.
        if(current == head) return false; 
        if(current.getPlayer().getName().equals(name)) return true; //Si el siguiente es el que se busca se retorna true.
        return checkIfPlayerExists(name, current.getNext());
    }

    public String print(LinkedListPlayerNode player){
      if (player == head.getPrevious()) { //Si el player a imprimir es igual a la cola, retorna el player en String y comienza el efecto dominó,
          //imprimiendo también todos los actuales player hasta llegar al primero.
            return player.getPlayer().toString();
        }
        return print(player.getNext()) + " " + player.getPlayer().toString();//Se realiza recursividad hasta llegar a la cola para comenzar a imprimir todos los players que se quedaron esperando...
    }


    public void delete(String goal){
        delete(head, goal);
    }
    private void delete(LinkedListPlayerNode player, String goal){
        if (player == null) return;//Si la cabeza es null, se retorna nada.
        if(player.getPlayer().getName().equals(goal)){
            if(player == head){
                if(head.getPrevious() == head && head.getNext() == head){//Si solo está la cabeza, se nullea la cabeza.
                    head = null;
                } else {//Si hay más aparte de la cabeza y se quiere eliminar la cabeza, de quita las referencias a la cabeza actual y se pone como nueva cabeza al head.Next.
                    head.getPrevious().setNext(head.getNext());
                    head.getNext().setPrevious(head.getPrevious());
                    head = head.getNext();
                }

            }else{//Si no es la cabeza.
                LinkedListPlayerNode prev = player.getPrevious();//Se guarda el prev y el next del player a eliminar.
                LinkedListPlayerNode next = player.getNext();
                prev.setNext(next); //Se quitan las referencias al player.
                next.setPrevious(prev);
            }
            return;
        }
        if(player.getNext() == head){
            return;
        }
        delete(player.getNext(), goal);//Se hace recursividad hasta encontrar al player a eliminar.

    }

    //-----Getters and setters-----


    public LinkedListPlayerNode getHead() {
        return head;
    }
    public void setHead(LinkedListPlayerNode head) {
        this.head = head;
    }

}
