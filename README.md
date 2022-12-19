# Space Trivia

### 🚀 About the project

An Android application consisting of a space trivia quiz, a slideshow for space facts and NASA daily images fetched from the Astronomy Picture Of the Day API.

Work done by Yosr Barghouthi (`yosr.barghouthi@etudiant-isi.utm.tn`) and Maissa Dridi (`maissa.dridi@etudiant-isi.utm.tn`) L3CS02

Course: Mobile development, fall 2022.

### 🛰️ At a glance

### 🔐User authentication

A first-time user can sign up by providing a **username** and a **password**.

The login data is stored in a SQLite database `login.db`

Activities and layouts: `MainActivity.java`and `activity_main.xml`

NB: background music starts playing the background with the help of the service `BackgroundSoundService.java`

### 🏠 Homepage

Upon entering correct login information, a greeting message is shown with username of user.

The user can start the space trivia quiz, brush up on space facts, look up NASA daily images from the APOD api or learn about the project.

Activities and layouts: `Homescreen.java`and `activity_homescreen.xml`

The class `DBHelper.java` performs operations to the `login.db` database. These operations include the creation of the table users, dropping it, inserting a row and checking credentials.

### 📝 Quiz

The quiz is comprised of 20 questions related to astronomy. Each question offers 3 options.

See `~/com/example/spacetrivia/questions.txt` for the list of questions and options.

Activities and layouts: `SpaceQuiz.java`and `activity_space_quiz.xml`

This activity relies on the `Question.java` class whose attributes describe a question, its options, the correct answer to it and its corresponding image.

### 🔢 Quiz Score

Upon completion of the quiz, the score is returned and a corresponding message is shown.

The user can retake the test by clicking on the “Retake test 🔂” button.

Activities and layouts: `ScoreActivity.java`and `activity_score.xml`

### 📚Brushing up on space facts

This section is a slider that displays space facts with a question, an image and a corresponding answer. The user swipes left to learn about space facts.

Activities and layouts: `SpaceFacts.java` and `activity_space_facts.xml`. This activity features a ViewPager that takes in a `SlideAdapter` object as its adapter.

`SlideAdapter.java` is a class linked to the layout file `slide.xml` and that configures the content of the slider. (images, text and background color )

### 🌌Nasa API (Astronomy picture of the day)

This section makes a call to APOD API provided by NASA to retrieve each NASA image of the day starting from december 12th,2022.

`Singleton.java` allows for one request queue to be made.

The activity `NasaImageOfTheDay.java` performs an API call to fetch a JSON array. Each element of the array contains the title, description, date and url of the image. These details are used to construct `NasaImage.java` objects, these objects will be later added to an ArrayList `mList` (attribute of the class `NasaImageOfTheDay.java` )

```java
String url = "https://api.nasa.gov/planetary/apod?api_key=mVHP73isNjhQZroWysMhXKYtTXbS9eOUMR2I4lSl&start_date=2022-12-12";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    //JSONArray jsonArray = response.getJSONArray("hits");

                    for(int i = response.length()-1 ; i>0 ; i--){
                        JSONObject jsonObject = response.getJSONObject(i);
                        String imgurl = jsonObject.getString("url");
                        String title = jsonObject.getString("title");
                        String date = jsonObject.getString("date");
                        String description = jsonObject.getString("explanation");
                        NasaImage post = new NasaImage(title,date,imgurl,description);
                        mList.add(post);

                    }

                    PostAdapter adapter = new PostAdapter(NASAImageOfTheDay.this , mList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NASAImageOfTheDay.this, "yikes", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
```

To format the elements of the arraylist, the layout file `activity_nasaimage_of_the_day.xml` uses a RecyclerView that takes in as adapter a `PostAdapter.java` object.

`PostAdapter.java` is linked to the layout file `eachimage.xml` and it parses the results array to set data to elements of the layout file.

### 📄About the project

This section displays information about the creators, as well as resources used in the project.

Activities and layouts: `AboutUs.java`and `activity_about_us.xml` , `AboutUsSliderAdapter.java` and `slide.xml`
