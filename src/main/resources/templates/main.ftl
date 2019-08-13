<#import "parts/common.ftl" as c>

<@c.page>

    <form method="post" class="form-group">
        <div class="form-group mb-3">
            <label for="number">Number</label>
            <div class="alert alert-primary" role="alert">
                <input type="text" name="number" class="form-control" id="number" maxlength="50"/>
            </div>
            <label for="numberOfPalindromes">Number of Palindromes</label>
            <div class="alert alert-primary" role="alert">
                <input type="text" name="numberOfPalindromes" class="form-control" id="numberOfPalindromes" maxlength="50"/>
            </div>
            <button type="submit" class="btn btn-primary">Find</button>
        </div>
    </form>

    <div class="card-columns">
        <div>History</div>
        <#list numbers as number>
            <div class="card my-3" style="width: 18rem;">
                <ul class="list-group list-group-horizontal-lg">
                    <label class="ml-3" for="num">Number</label>
                    <li class="list-group-item" id="num">${number.number}</li>
                    <label class="ml-3" for="num">Number of Palindromes</label>
                    <li class="list-group-item" id="numOfPalindromes">${number.numberOfPalindromes}</li>
                    <label class="ml-3" for="num">Min Palindrome</label>
                    <li class="list-group-item" id="numMin">${number.minPalindrome}</li>
                    <label class="ml-3" for="num">Max Palindrome</label>
                    <li class="list-group-item" id="numMax">${number.maxPalindrome}</li>
                </ul>
            </div>
        <#else>
            No Palindromes
        </#list>
    </div>
</@c.page>