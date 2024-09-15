<script>

    import {onMount} from "svelte";

    let newQuestion;
    let newOptions;
    let user = {
        username: "test",
        email: "test@email.com",
        }


    let result = fetch("http://localhost:8080/users").then((response) => {
          return response.json();
        }
      )

    let pollResult = fetch("http://localhost:8080/polls").then((response) => {
              return response.json();
            }
          )


    function createNewPoll(){

        let optionList = newOptions.split(",");

        fetch("http://localhost:8080/polls", {
            method: "POST",
            body: JSON.stringify({
                question: newQuestion,
                options: optionList,
                user: user
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then((response) => {
            if(response.status === 201) {
            alert('Poll created!');
            newQuestion = "";
            newOptions = [];
            }
        }).catch((error) => {
        alert(error.message);
        })
    }

    onMount(() => {
        const intervalId = setInterval(() => {
          result = fetch("http://localhost:8080/users").then((response) => response.json());
        }, 5000);

        return () => clearInterval(intervalId);
      })

    function vote(option){
        fetch("http://localhost:8080/vote", {
                method: "POST",
                body: JSON.stringify({
                    creator: user,
                    option: {caption: option.caption}
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            }).then((response) => {
                alert('Vote placed!');
            }).catch((error) => {
            alert(error.message);
            })
    }
</script>

<div class="polls">
  <h1>Polls</h1>
{#await pollResult}
  loading
{:then ready}
    {#each ready as poll}
        {poll.id}
        <b>Question: {poll.question}</b>
        {#each poll.options as option}
            {option.caption}
            <button on:click={() => vote(option)}>Vote</button>
        {/each}

        <br>
    {/each}
{:catch error}
  {error}
{/await}
</div>


<div class="create-poll">
    <h2>Create new poll</h2>
    <label for="create-question">Question:</label>
    <input id="create-question" type="text" bind:value={newQuestion}>

    <label for="create-options">Options:</label>
    <input id="create-options" type="text" bind:value={newOptions}>

    <button on:click={createNewPoll}>Create</button>
</div>

<div class="users">
  <h1>Users</h1>
{#await result}
  loading
{:then ready}
  <table>
    <thead>
      <tr>
        <th>Username</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
    {#each ready as user}
      <tr>
        <td>{user.username}</td>
        <td>{user.email}</td>
      </tr>
    {/each}
  </tbody>
  </table>
{:catch error}
  {error}
{/await}
</div>