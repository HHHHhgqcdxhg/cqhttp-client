package com.ggemo.cqhttpclient.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadObjectPool<T> {
    /**
     * 对象池
     */
    private List<T> pool;

    /**
     * 对象池伴随list,其中的元素标识着对象池里相同下标的元素是否正被占用.false表示未被占用
     */
    private List<Boolean> poolAlong;

    /**
     * 标识着线程拥有的对象在对象池中的位置
     */
    private Map<Thread, Integer> belongsMap;

    private ReentrantLock lock;

    public ThreadObjectPool() {
        this.pool = new ArrayList<>();
        this.poolAlong = new ArrayList<>();
        this.belongsMap = new HashMap<>();
        this.lock = new ReentrantLock();
    }

    public T putAngGet(T obj){
        Thread currentThread = Thread.currentThread();
        lock.lock();
        try{
            pool.add(obj);
            poolAlong.add(true);
            belongsMap.put(currentThread, poolAlong.size() - 1);
            return obj;
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        Thread currentThread = Thread.currentThread();
        lock.lock();
        try{
            for (int i = 0; i < poolAlong.size(); i++) {
                if(!poolAlong.get(i)){
                    poolAlong.set(i, true);
                    belongsMap.put(currentThread, i);
                    return pool.get(i);
                }
            }
            return null;
        }finally {
            lock.unlock();
        }
    }

    public void giveBack(){
        Thread currentThread = Thread.currentThread();
        lock.lock();
        try{
            int i = belongsMap.get(currentThread);
            poolAlong.set(i, false);
            belongsMap.remove(currentThread);
        }finally {
            lock.unlock();
        }
    }
}
