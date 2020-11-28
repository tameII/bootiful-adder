package fr.univlorraine.bootiful.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdderService {
    private int num = new Random(10).nextInt();

    public void baseNum(int base) {
        this.num = base;
    }

    public int currentBase() {
        return num;
    }

    public int add(int adder) {
        return this.num + adder;
    }

    public int substract(int adder) { return this.num - adder;}

    public int accumulate(int adder) {
        return this.num += adder;
    }

}
