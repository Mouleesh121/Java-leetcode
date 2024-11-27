class FizzBuzz {
    private int n;
    int count;
    public FizzBuzz(int n) {
        this.n = n;
        this.count = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized(this){
            while(count <= n){
                if(count % 3 == 0 && count % 5 != 0){
                    printFizz.run();
                    count++;
                    notifyAll();
                }else{
                    wait();
                    continue;
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized(this){
            while(count <= n){
                if(count % 5 == 0 && count % 3 != 0){
                    printBuzz.run();
                    count++;
                    notifyAll();
                }else{
                    wait();
                    continue;
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized(this){
            while(count <= n){
                if(count % 3 == 0 && count % 5 == 0){
                    printFizzBuzz.run();
                    count++;
                    notifyAll();
                }else{
                    wait();
                    continue;
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized(this){
            while(count <= n){
                if(count % 3 == 0 || count % 5 == 0){
                    wait();
                    continue;
                }
                printNumber.accept(count);
                count++;
                notifyAll();
            }
        }
    }
}
