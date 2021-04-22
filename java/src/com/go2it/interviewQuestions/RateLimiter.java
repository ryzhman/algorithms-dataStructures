package com.go2it.interviewQuestions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Create a rate limiter that will limit the number of requests made to the service:
 * - by 10 requests per minute (10 requests during 1 minute)
 * - by 10 requests per 10 sec (10 requests during 10 seconds)
 */
public class RateLimiter {
    private static Map<String, Entry> idToNumberOfReqs = new HashMap<>();

    public static boolean validateCustomer(String customerId) {
        // timestamp
        final Entry reqPerMinute = idToNumberOfReqs.get(customerId);
        if (reqPerMinute == null) {
            final Entry entry = new Entry(LocalDateTime.now());
            idToNumberOfReqs.put(customerId, entry);
            return true;
        }
        return reqPerMinute.rateLimit(LocalDateTime.now());
    }

    static class Entry {
        private LocalDateTime recentMinute;
        private int numOfReqs = 0;
        private Queue<LocalDateTime> allRequests;

        public Entry(LocalDateTime recentMinute) {
            this.recentMinute = recentMinute;
            this.numOfReqs++;
            allRequests = new ArrayDeque<>();
        }

        public void addRequestPerUser(LocalDateTime recentMinute) {
            if (recentMinute.getSecond() > 0 && recentMinute.getSecond() < 59) {
                numOfReqs++;
            } else {
                numOfReqs = 0;
            }
        }

        /**
         * Checks if the request is allowed
         *
         * @param currentMinute
         * @return
         */
        public boolean rateLimit(LocalDateTime currentMinute) {
            final LocalDateTime firstReq = allRequests.peek();
            // if it is the first request or the time of the first requests in the queue is within 10 sec period
            if (firstReq == null || Duration.between(firstReq, currentMinute).getSeconds() < 10) {
                if (allRequests.size() > 10) {
                    return false;
                }
                allRequests.add(currentMinute);
                return true;
            } else {
                // remove the oldest entry in queue (it is not required anymore) and check the next entry
                allRequests.poll();
                rateLimit(currentMinute);
            }
            return true;

            // check that the number of requests per minute is allowed
//            if (currentMinute.getMinute() == recentMinute.getMinute()) {
//                if (numOfReqs < 10) {
//                    this.numOfReqs++;
//                    return true;
//                }
//                return false;
//            } else {
//                this.recentMinute = currentMinute;
//                this.numOfReqs = 1;
//                return true;
//            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        validateCustomer("A");
        System.out.println(validateCustomer("A"));
        System.out.println(validateCustomer("A"));
        Thread.sleep(7000);
        System.out.println(validateCustomer("A"));
    }


}
