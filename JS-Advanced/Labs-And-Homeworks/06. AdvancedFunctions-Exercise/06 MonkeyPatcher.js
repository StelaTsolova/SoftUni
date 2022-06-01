function solution(argument) {
    if (argument == 'upvote') {
        this.upvotes++;
    } else if (argument == 'downvote') {
        this.downvotes++
    } else if (argument == 'score') {
        let balance = this.upvotes - this.downvotes;
        let totalVotes = this.upvotes + this.downvotes;

        let reportedUpvotes = this.upvotes;
        let reportedDownvotess = this.downvotes;

        if (totalVotes > 50) {
            let number = Math.ceil(Math.max(this.upvotes, this.downvotes) * 0.25);

            reportedUpvotes += number;
            reportedDownvotess += number;
        }

        let rating = '';
        if (((this.upvotes / totalVotes) * 100) > 66 && totalVotes >= 10) {
            rating = 'hot';
        } else if (balance >= 0 && totalVotes > 100) {
            rating = 'controversial';
        } else if (balance < 0 && totalVotes >= 10) {
            rating = 'unpopular';
        } else {
            rating = 'new';
        }

        return [reportedUpvotes, reportedDownvotess, balance, rating];
    }
}