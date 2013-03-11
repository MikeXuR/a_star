/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;
/**
 *
 * @author akshay
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    

   public static void main(String[] args) {
        // TODO code application logic here
        //Graph g=new Graph();
        System.out.println("Please enter the start grid of 4x4 in 8 puzzle problem\n");
        node start=new node();
        System.out.println("Please enter the goal grid of 4x4 in 8 puzzle problem\n");
        node goal = new node();
        
        /*for(int i=0;i<10;i++)
        {
            node n=new node(i);
            (g.nodes).add(n);
            g.add_heuristic_cost_estimate(n, goal, 0);
        }
        for(int i=1;i<5;i++)
        {
            edge e=new edge(0+i,g.getNodeByNum(0),g.getNodeByNum(i));
            (g.edges).add(e);
        }
        for(int i=1;i<5;i++)
        {
            edge e=new edge(4+2*i,g.getNodeByNum(i),g.getNodeByNum(4+i));
            (g.edges).add(e);
        }
        for(int i=5;i<9;i++)
        {
            edge e=new edge(9+i,g.getNodeByNum(i),g.getNodeByNum(9));
            (g.edges).add(e);
        }*/
       /*node start=new node(0);
       start.printNode();
       node goal=new node(9);
       start.printNode();
       System.out.println("equals"+start.equals(goal)+"\n");
       */
        ASTAR a=new ASTAR();
        a.findBestPath(start,goal);
        //define heurisstic function
    }
}
