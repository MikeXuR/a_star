/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author akshay
 */
public class node {
    public int[][] lst;
    public int heu;
    public int size;
    node()
    {
        size=3;
        lst=new int[size][size];
        Scanner user_input= new Scanner(System.in);
        int num1,num2;
        for(num1=0;num1<size*size;num1++)
        {
            num2=user_input.nextInt();
            lst[(num1%size)][(num1/size)]=num2;
        }
    }
    node(int[][] lst1)
    {
        //copy(lst1);
        size=3;
        lst=new int[size][size];
        int num1;
        for(num1=0;num1<size*size;num1++)
        {
            lst[(num1%size)][(num1/size)]=lst1[(num1%size)][(num1/size)];
        }
    }
    public int heuristic(node g)
    {
        int num1,num2=0;
        for(num1=0;num1<size*size;num1++)
        {
            if(lst[(num1%size)][(num1/size)]!=g.lst[(num1%size)][(num1/size)])
            {
                num2++;
            }
        }
        return num2;
    }
    public List<listNode> getNeighbours(int num,listNode ln)
    {
        List<listNode> l=new ArrayList<listNode>();
        int num1,xpos=0,ypos=0;
        for(num1=0;num1<size*size;num1++)
        {
            xpos=num1%size;
            ypos=num1/size;
            if(lst[xpos][ypos]==-1)
            {
                break;
            }
            
        }
        node new_n,temp_n;
            listNode lsn;
            if(xpos<size-1)
            {
                new_n=new node(lst);
                int temp=new_n.lst[xpos][ypos];
                new_n.lst[xpos][ypos]=new_n.lst[xpos+1][ypos];
                new_n.lst[xpos+1][ypos]=temp;
                //check for ancestors
                lsn=new listNode(new_n,ln,num+1);
                if(!lsn.checkParent())
                {
                    l.add(lsn);
                }
            }
            if(ypos<size-1)
            {
                new_n=new node(lst);
                int temp=new_n.lst[xpos][ypos];
                new_n.lst[xpos][ypos]=new_n.lst[xpos][ypos+1];
                new_n.lst[xpos][ypos+1]=temp;
                lsn=new listNode(new_n,ln,num+1);
                if(!lsn.checkParent())
                {
                    l.add(lsn);
                }
            }
            if(xpos>0)
            {
                new_n=new node(lst);
                int temp=new_n.lst[xpos][ypos];
                new_n.lst[xpos][ypos]=new_n.lst[xpos-1][ypos];
                new_n.lst[xpos-1][ypos]=temp;
                //check for ancestors
                lsn=new listNode(new_n,ln,num+1);
                if(!lsn.checkParent())
                {
                    l.add(lsn);
                }
            }
            if(ypos>0)
            {
                new_n=new node(lst);
                int temp=new_n.lst[xpos][ypos];
                new_n.lst[xpos][ypos]=new_n.lst[xpos][ypos-1];
                new_n.lst[xpos][ypos-1]=temp;
                lsn=new listNode(new_n,ln,num+1);
                if(!lsn.checkParent())
                {
                    l.add(lsn);
                }
            }
        return l;
    }
    public void printNode()
    {
        int num1;
        for(num1=0;num1<size*size;num1++)
        {
            if(num1%size==0){System.out.println("\n");}
            System.out.print(" "+lst[(num1%size)][(num1/size)]);
        }
        System.out.println("\n");
    }
            @Override
            public boolean equals(Object obj) 
            {
                    if(obj ==null) return false;
                    if(getClass()!=obj.getClass()) return false;
                    node other=(node) obj;
                    int num1;
                    boolean isSame=true;
                    for(num1=0;num1<size*size;num1++)
                    {
                        if(lst[(num1%size)][(num1/size)]!=other.lst[(num1%size)][(num1/size)])
                        {
                            isSame=false;
                            break;
                        }
                    }
                    return isSame;
            }
}
