package com.angon.tree_of_history;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TreeActivity extends AppCompatActivity {

    ImageView mainPerson, third1, fourth1, fifth1, sixth1,
            second2, third2,
            second3, third3, fourth3, fifth3,
            second4, third4, fourth4, fifth4, sixth4, seventh4,
            second5, third5, fourth5, fifth5, sixth5, seventh5,
            second6, third6, fourth6, fifth6, sixth6, seventh6,
            second7, third7, fourth7, fifth7, sixth7, seventh7;
    TextView mainPersonName, third1Name, fourth1Name, fifth1Name, sixth1Name,
            second2Name, third2Name,
            second3Name, third3Name, fourth3Name, fifth3Name,
            second4Name, third4Name, fourth4Name, fifth4Name, sixth4Name, seventh4Name,
            second5Name, third5Name, fourth5Name, fifth5Name, sixth5Name, seventh5Name,
            second6Name, third6Name, fourth6Name, fifth6Name, sixth6Name, seventh6Name,
            second7Name, third7Name, fourth7Name, fifth7Name, sixth7Name, seventh7Name;
    LinearLayout mainPersonLayout, third1Layout, fourth1Layout, fifth1Layout, sixth1Layout,
            second2Layout, third2Layout,
            second3Layout, third3Layout, fourth3Layout, fifth3Layout,
            second4Layout, third4Layout, fourth4Layout, fifth4Layout, sixth4Layout, seventh4Layout,
            second5Layout, third5Layout, fourth5Layout, fifth5Layout, sixth5Layout, seventh5Layout,
            second6Layout, third6Layout, fourth6Layout, fifth6Layout, sixth6Layout, seventh6Layout,
            second7Layout, third7Layout, fourth7Layout, fifth7Layout, sixth7Layout, seventh7Layout;
    TableLayout generationsTable;
    TableRow thirdRow, fourthRow, fifthRow, sixthRow, seventhRow;

    SQLiteDatabase database;
    PeopleDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();

        mainPerson = findViewById(R.id.mainPerson);
        third1 = findViewById(R.id.third1);
        fourth1 = findViewById(R.id.fourth1);
        fifth1 = findViewById(R.id.fifth1);
        sixth1 = findViewById(R.id.sixth1);
        second2 = findViewById(R.id.second2);
        third2 = findViewById(R.id.third2);
        second3 = findViewById(R.id.second3);
        third3 = findViewById(R.id.third3);
        fourth3 = findViewById(R.id.fourth3);
        fifth3 = findViewById(R.id.fifth3);
        second4 = findViewById(R.id.second4);
        third4 = findViewById(R.id.third4);
        fourth4 = findViewById(R.id.fourth4);
        fifth4 = findViewById(R.id.fifth4);
        sixth4 = findViewById(R.id.sixth4);
        seventh4 = findViewById(R.id.seventh4);
        second5 = findViewById(R.id.second5);
        third5 = findViewById(R.id.third5);
        fourth5 = findViewById(R.id.fourth5);
        fifth5 = findViewById(R.id.fifth5);
        sixth5 = findViewById(R.id.sixth5);
        seventh5 = findViewById(R.id.seventh5);
        second6 = findViewById(R.id.second6);
        third6 = findViewById(R.id.third6);
        fourth6 = findViewById(R.id.fourth6);
        fifth6 = findViewById(R.id.fifth6);
        sixth6 = findViewById(R.id.sixth6);
        seventh6 = findViewById(R.id.seventh6);
        second7 = findViewById(R.id.second7);
        third7 = findViewById(R.id.third7);
        fourth7 = findViewById(R.id.fourth7);
        fifth7 = findViewById(R.id.fifth7);
        sixth7 = findViewById(R.id.sixth7);
        seventh7 = findViewById(R.id.seventh7);

        mainPersonName = findViewById(R.id.mainPersonName);
        third1Name = findViewById(R.id.third1Name);
        fourth1Name = findViewById(R.id.fourth1Name);
        fifth1Name = findViewById(R.id.fifth1Name);
        sixth1Name = findViewById(R.id.sixth1Name);
        second2Name = findViewById(R.id.second2Name);
        third2Name = findViewById(R.id.third2Name);
        second3Name = findViewById(R.id.second3Name);
        third3Name = findViewById(R.id.third3Name);
        fourth3Name = findViewById(R.id.fourth3Name);
        fifth3Name = findViewById(R.id.fifth3Name);
        second4Name = findViewById(R.id.second4Name);
        third4Name = findViewById(R.id.third4Name);
        fourth4Name = findViewById(R.id.fourth4Name);
        fifth4Name = findViewById(R.id.fifth4Name);
        sixth4Name = findViewById(R.id.sixth4Name);
        seventh4Name = findViewById(R.id.seventh4Name);
        second5Name = findViewById(R.id.second5Name);
        third5Name = findViewById(R.id.third5Name);
        fourth5Name = findViewById(R.id.fourth5Name);
        fifth5Name = findViewById(R.id.fifth5Name);
        sixth5Name = findViewById(R.id.sixth5Name);
        seventh5Name = findViewById(R.id.seventh5Name);
        second6Name = findViewById(R.id.second6Name);
        third6Name = findViewById(R.id.third6Name);
        fourth6Name = findViewById(R.id.fourth6Name);
        fifth6Name = findViewById(R.id.fifth6Name);
        sixth6Name = findViewById(R.id.sixth6Name);
        seventh6Name = findViewById(R.id.seventh6Name);
        second7Name = findViewById(R.id.second7Name);
        third7Name = findViewById(R.id.third7Name);
        fourth7Name = findViewById(R.id.fourth7Name);
        fifth7Name = findViewById(R.id.fifth7Name);
        sixth7Name = findViewById(R.id.sixth7Name);
        seventh7Name = findViewById(R.id.seventh7Name);

        mainPersonLayout = findViewById(R.id.mainPersonLayout);
        third1Layout = findViewById(R.id.third1Layout);
        fourth1Layout = findViewById(R.id.fourth1Layout);
        fifth1Layout = findViewById(R.id.fifth1Layout);
        sixth1Layout = findViewById(R.id.sixth1Layout);
        second2Layout = findViewById(R.id.second2Layout);
        third2Layout = findViewById(R.id.third2Layout);
        second3Layout = findViewById(R.id.second3Layout);
        third3Layout = findViewById(R.id.third3Layout);
        fourth3Layout = findViewById(R.id.fourth3Layout);
        fifth3Layout = findViewById(R.id.fifth3Layout);
        second4Layout = findViewById(R.id.second4Layout);
        third4Layout = findViewById(R.id.third4Layout);
        fourth4Layout = findViewById(R.id.fourth4Layout);
        fifth4Layout = findViewById(R.id.fifth4Layout);
        sixth4Layout = findViewById(R.id.sixth4Layout);
        seventh4Layout = findViewById(R.id.seventh4Layout);
        second5Layout = findViewById(R.id.second5Layout);
        third5Layout = findViewById(R.id.third5Layout);
        fourth5Layout = findViewById(R.id.fourth5Layout);
        fifth5Layout = findViewById(R.id.fifth5Layout);
        sixth5Layout = findViewById(R.id.sixth5Layout);
        seventh5Layout = findViewById(R.id.seventh5Layout);
        second6Layout = findViewById(R.id.second6Layout);
        third6Layout = findViewById(R.id.third6Layout);
        fourth6Layout = findViewById(R.id.fourth6Layout);
        fifth6Layout = findViewById(R.id.fifth6Layout);
        sixth6Layout = findViewById(R.id.sixth6Layout);
        seventh6Layout = findViewById(R.id.seventh6Layout);
        second7Layout = findViewById(R.id.second7Layout);
        third7Layout = findViewById(R.id.third7Layout);
        fourth7Layout = findViewById(R.id.fourth7Layout);
        fifth7Layout = findViewById(R.id.fifth7Layout);
        sixth7Layout = findViewById(R.id.sixth7Layout);
        seventh7Layout = findViewById(R.id.seventh7Layout);

        generationsTable = findViewById(R.id.generationsTable);
        thirdRow = findViewById(R.id.thirdRow);
        fourthRow = findViewById(R.id.fourthRow);
        fifthRow = findViewById(R.id.fifthRow);
        sixthRow = findViewById(R.id.sixthRow);
        seventhRow = findViewById(R.id.seventhRow);

        final Animation adding_press = AnimationUtils.loadAnimation(this, R.anim.adding_press);

        // First generation
        Cursor firstGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(1)}, null, null, null);
        for (int i = 0; i < firstGeneration.getCount(); i++) {
            firstGeneration.moveToNext();
            if (i == 0) {
                mainPersonLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 1);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (firstGeneration.getString(5) != null) {
                    mainPerson.setImageDrawable(Drawable.createFromPath(firstGeneration.getString(5)));
                } else {
                    mainPersonLayout.removeView(mainPerson);
                }
                mainPersonName.setText(firstGeneration.getString(1));
            }
            if (i == 1) {
                third1Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 1);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (firstGeneration.getString(5) != null) {
                    third1.setImageDrawable(Drawable.createFromPath(firstGeneration.getString(5)));
                } else {
                    third1Layout.removeView(third1);
                }
                third1Name.setText(firstGeneration.getString(1));
            }
            if (i == 2) {
                fourth1Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 1);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (firstGeneration.getString(5) != null) {
                    fourth1.setImageDrawable(Drawable.createFromPath(firstGeneration.getString(5)));
                } else {
                    fourth1Layout.removeView(fourth1);
                }
                fourth1Name.setText(firstGeneration.getString(1));
            }
            if (i == 3) {
                fifth1Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 1);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (firstGeneration.getString(5) != null) {
                    fifth1.setImageDrawable(Drawable.createFromPath(firstGeneration.getString(5)));
                } else {
                    fifth1Layout.removeView(fifth1);
                }
                fifth1Name.setText(firstGeneration.getString(1));
            }
            if (i == 4) {
                sixth1Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 1);
                        intent.putExtra("Number", 5);
                        startActivityForResult(intent, 1);
                    }
                });
                if (firstGeneration.getString(5) != null) {
                    sixth1.setImageDrawable(Drawable.createFromPath(firstGeneration.getString(5)));
                } else {
                    sixth1Layout.removeView(sixth1);
                }
                sixth1Name.setText(firstGeneration.getString(1));
            }
        }
        if (firstGeneration.getCount() == 0) {
            mainPerson.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 1);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third1.setAlpha(0.0f);
            fourth1.setAlpha(0.0f);
            fifth1.setAlpha(0.0f);
            sixth1.setAlpha(0.0f);
        }
        if (firstGeneration.getCount() == 1) {
            third1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 1);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth1.setAlpha(0.0f);
            fifth1.setAlpha(0.0f);
            sixth1.setAlpha(0.0f);
        }
        if (firstGeneration.getCount() == 2) {
            fourth1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 1);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth1.setAlpha(0.0f);
            sixth1.setAlpha(0.0f);
        }
        if (firstGeneration.getCount() == 3) {
            fifth1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 1);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            sixth1.setAlpha(0.0f);
        }
        if (firstGeneration.getCount() == 4) {
            sixth1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 1);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        firstGeneration.close();
        // First generation

        // Second generation
        Cursor secondGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(2)}, null, null, null);
        for (int i = 0; i < secondGeneration.getCount(); i++) {
            secondGeneration.moveToNext();
            if (i == 0) {
                second2Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 2);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (secondGeneration.getString(5) != null) {
                    second2.setImageDrawable(Drawable.createFromPath(secondGeneration.getString(5)));
                } else {
                    second2Layout.removeView(second2);
                }
                second2Name.setText(secondGeneration.getString(1));
            }
            if (i == 1) {
                third2Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 2);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (secondGeneration.getString(5) != null) {
                    third2.setImageDrawable(Drawable.createFromPath(secondGeneration.getString(5)));
                } else {
                    third2Layout.removeView(third2);
                }
                third2Name.setText(secondGeneration.getString(1));
            }
        }
        if (secondGeneration.getCount() == 0) {
            second2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 2);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third2.setAlpha(0.0f);
        }
        if (secondGeneration.getCount() == 1) {
            third2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 2);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        secondGeneration.close();
        // Second generation

        // Third generation
        Cursor thirdGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(3)}, null, null, null);
        for (int i = 0; i < thirdGeneration.getCount(); i++) {
            thirdGeneration.moveToNext();
            if (i == 0) {
                second3Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 3);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (thirdGeneration.getString(5) != null) {
                    second3.setImageDrawable(Drawable.createFromPath(thirdGeneration.getString(5)));
                } else {
                    second3Layout.removeView(second3);
                }
                second3Name.setText(thirdGeneration.getString(1));
            }
            if (i == 1) {
                third3Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 3);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (thirdGeneration.getString(5) != null) {
                    third3.setImageDrawable(Drawable.createFromPath(thirdGeneration.getString(5)));
                } else {
                    third3Layout.removeView(third3);
                }
                third3Name.setText(thirdGeneration.getString(1));
            }
            if (i == 2) {
                fourth3Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 3);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (thirdGeneration.getString(5) != null) {
                    fourth3.setImageDrawable(Drawable.createFromPath(thirdGeneration.getString(5)));
                } else {
                    fourth3Layout.removeView(fourth3);
                }
                fourth3Name.setText(thirdGeneration.getString(1));
            }
            if (i == 3) {
                fifth3Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 3);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (thirdGeneration.getString(5) != null) {
                    fifth3.setImageDrawable(Drawable.createFromPath(thirdGeneration.getString(5)));
                } else {
                    fifth3Layout.removeView(fifth3);
                }
                fifth3Name.setText(thirdGeneration.getString(1));
            }
        }
        if (thirdGeneration.getCount() == 0) {
            second3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 3);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third3.setAlpha(0.0f);
            fourth3.setAlpha(0.0f);
            fifth3.setAlpha(0.0f);
        }
        if (thirdGeneration.getCount() == 1) {
            third3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 3);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth3.setAlpha(0.0f);
            fifth3.setAlpha(0.0f);
        }
        if (thirdGeneration.getCount() == 2) {
            fourth3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 3);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth3.setAlpha(0.0f);
        }
        if (thirdGeneration.getCount() == 3) {
            fifth3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 3);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        thirdGeneration.close();
        // Third generation

        // Fourth generation
        Cursor fourthGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(4)}, null, null, null);
        for (int i = 0; i < fourthGeneration.getCount(); i++) {
            fourthGeneration.moveToNext();
            if (i == 0) {
                second4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    second4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    second4Layout.removeView(second4);
                }
                second4Name.setText(fourthGeneration.getString(1));
            }
            if (i == 1) {
                third4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    third4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    third4Layout.removeView(third4);
                }
                third4Name.setText(fourthGeneration.getString(1));
            }
            if (i == 2) {
                fourth4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    fourth4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    fourth4Layout.removeView(fourth4);
                }
                fourth4Name.setText(fourthGeneration.getString(1));
            }
            if (i == 3) {
                fifth4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    fifth4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    fifth4Layout.removeView(fifth4);
                }
                fifth4Name.setText(fourthGeneration.getString(1));
            }
            if (i == 4) {
                sixth4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 5);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    sixth4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    sixth4Layout.removeView(sixth4);
                }
                sixth4Name.setText(fourthGeneration.getString(1));
            }
            if (i == 5) {
                seventh4Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 4);
                        intent.putExtra("Number", 6);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fourthGeneration.getString(5) != null) {
                    seventh4.setImageDrawable(Drawable.createFromPath(fourthGeneration.getString(5)));
                } else {
                    seventh4Layout.removeView(seventh4);
                }
                seventh4Name.setText(fourthGeneration.getString(1));
            }
        }
        if (fourthGeneration.getCount() == 0) {
            second4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third4.setAlpha(0.0f);
            fourth4.setAlpha(0.0f);
            fifth4.setAlpha(0.0f);
            sixth4.setAlpha(0.0f);
            seventh4.setAlpha(0.0f);
        }
        if (fourthGeneration.getCount() == 1) {
            third4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth4.setAlpha(0.0f);
            fifth4.setAlpha(0.0f);
            sixth4.setAlpha(0.0f);
            seventh4.setAlpha(0.0f);
        }
        if (fourthGeneration.getCount() == 2) {
            fourth4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth4.setAlpha(0.0f);
            sixth4.setAlpha(0.0f);
            seventh4.setAlpha(0.0f);
        }
        if (fourthGeneration.getCount() == 3) {
            fifth4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            sixth4.setAlpha(0.0f);
            seventh4.setAlpha(0.0f);
        }
        if (fourthGeneration.getCount() == 4) {
            sixth4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            seventh4.setAlpha(0.0f);
        }
        if (fourthGeneration.getCount() == 5) {
            seventh4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 4);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        fourthGeneration.close();
        // Fourth generation

        // Fifth generation
        Cursor fifthGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(5)}, null, null, null);
        for (int i = 0; i < fifthGeneration.getCount(); i++) {
            fifthGeneration.moveToNext();
            if (i == 0) {
                second5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    second5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    second5Layout.removeView(second5);
                }
                second5Name.setText(fifthGeneration.getString(1));
            }
            if (i == 1) {
                third5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    third5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    third5Layout.removeView(third5);
                }
                third5Name.setText(fifthGeneration.getString(1));
            }
            if (i == 2) {
                fourth5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    fourth5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    fourth5Layout.removeView(fourth5);
                }
                fourth5Name.setText(fifthGeneration.getString(1));
            }
            if (i == 3) {
                fifth5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    fifth5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    fifth5Layout.removeView(fifth5);
                }
                fifth5Name.setText(fifthGeneration.getString(1));
            }
            if (i == 4) {
                sixth5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 5);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    sixth5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    sixth5Layout.removeView(sixth5);
                }
                sixth5Name.setText(fifthGeneration.getString(1));
            }
            if (i == 5) {
                seventh5Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 5);
                        intent.putExtra("Number", 6);
                        startActivityForResult(intent, 1);
                    }
                });
                if (fifthGeneration.getString(5) != null) {
                    seventh5.setImageDrawable(Drawable.createFromPath(fifthGeneration.getString(5)));
                } else {
                    seventh5Layout.removeView(seventh5);
                }
                seventh5Name.setText(fifthGeneration.getString(1));
            }
        }
        if (fifthGeneration.getCount() == 0) {
            second5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third5.setAlpha(0.0f);
            fourth5.setAlpha(0.0f);
            fifth5.setAlpha(0.0f);
            sixth5.setAlpha(0.0f);
            seventh5.setAlpha(0.0f);
        }
        if (fifthGeneration.getCount() == 1) {
            third5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth5.setAlpha(0.0f);
            fifth5.setAlpha(0.0f);
            sixth5.setAlpha(0.0f);
            seventh5.setAlpha(0.0f);
        }
        if (fifthGeneration.getCount() == 2) {
            fourth5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth5.setAlpha(0.0f);
            sixth5.setAlpha(0.0f);
            seventh5.setAlpha(0.0f);
        }
        if (fifthGeneration.getCount() == 3) {
            fifth5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            sixth5.setAlpha(0.0f);
            seventh5.setAlpha(0.0f);
        }
        if (fifthGeneration.getCount() == 4) {
            sixth5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            seventh5.setAlpha(0.0f);
        }
        if (fifthGeneration.getCount() == 5) {
            seventh5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 5);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        fifthGeneration.close();
        // Fifth generation

        // Sixth generation
        Cursor sixthGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(6)}, null, null, null);
        for (int i = 0; i < sixthGeneration.getCount(); i++) {
            sixthGeneration.moveToNext();
            if (i == 0) {
                second6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    second6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    second6Layout.removeView(second6);
                }
                second6Name.setText(sixthGeneration.getString(1));
            }
            if (i == 1) {
                third6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    third6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    third6Layout.removeView(third6);
                }
                third6Name.setText(sixthGeneration.getString(1));
            }
            if (i == 2) {
                fourth6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    fourth6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    fourth6Layout.removeView(fourth6);
                }
                fourth6Name.setText(sixthGeneration.getString(1));
            }
            if (i == 3) {
                fifth6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    fifth6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    fifth6Layout.removeView(fifth6);
                }
                fifth6Name.setText(sixthGeneration.getString(1));
            }
            if (i == 4) {
                sixth6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 5);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    sixth6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    sixth6Layout.removeView(sixth6);
                }
                sixth6Name.setText(sixthGeneration.getString(1));
            }
            if (i == 5) {
                seventh6Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 6);
                        intent.putExtra("Number", 6);
                        startActivityForResult(intent, 1);
                    }
                });
                if (sixthGeneration.getString(5) != null) {
                    seventh6.setImageDrawable(Drawable.createFromPath(sixthGeneration.getString(5)));
                } else {
                    seventh6Layout.removeView(seventh6);
                }
                seventh6Name.setText(sixthGeneration.getString(1));
            }
        }
        if (sixthGeneration.getCount() == 0) {
            second6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third6.setAlpha(0.0f);
            fourth6.setAlpha(0.0f);
            fifth6.setAlpha(0.0f);
            sixth6.setAlpha(0.0f);
            seventh6.setAlpha(0.0f);
        }
        if (sixthGeneration.getCount() == 1) {
            third6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth6.setAlpha(0.0f);
            fifth6.setAlpha(0.0f);
            sixth6.setAlpha(0.0f);
            seventh6.setAlpha(0.0f);
        }
        if (sixthGeneration.getCount() == 2) {
            fourth6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth6.setAlpha(0.0f);
            sixth6.setAlpha(0.0f);
            seventh6.setAlpha(0.0f);
        }
        if (sixthGeneration.getCount() == 3) {
            fifth6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            sixth6.setAlpha(0.0f);
            seventh6.setAlpha(0.0f);
        }
        if (sixthGeneration.getCount() == 4) {
            sixth6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            seventh6.setAlpha(0.0f);
        }
        if (sixthGeneration.getCount() == 5) {
            seventh6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 6);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        sixthGeneration.close();
        // Sixth generation

        // Seventh generation
        Cursor seventhGeneration = database.query("PeopleData", null, "Generation = ?",
                new String[] {Integer.toString(7)}, null, null, null);
        for (int i = 0; i < seventhGeneration.getCount(); i++) {
            seventhGeneration.moveToNext();
            if (i == 0) {
                second7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 1);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    second7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    second7Layout.removeView(second7);
                }
                second7Name.setText(seventhGeneration.getString(1));
            }
            if (i == 1) {
                third7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 2);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    third7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    third7Layout.removeView(third7);
                }
                third7Name.setText(seventhGeneration.getString(1));
            }
            if (i == 2) {
                fourth7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 3);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    fourth7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    fourth7Layout.removeView(fourth7);
                }
                fourth7Name.setText(seventhGeneration.getString(1));
            }
            if (i == 3) {
                fifth7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 4);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    fifth7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    fifth7Layout.removeView(fifth7);
                }
                fifth7Name.setText(seventhGeneration.getString(1));
            }
            if (i == 4) {
                sixth7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 5);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    sixth7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    sixth7Layout.removeView(sixth7);
                }
                sixth7Name.setText(seventhGeneration.getString(1));
            }
            if (i == 5) {
                seventh7Layout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TreeActivity.this, ViewingActivity.class);
                        intent.putExtra("Generation", 7);
                        intent.putExtra("Number", 6);
                        startActivityForResult(intent, 1);
                    }
                });
                if (seventhGeneration.getString(5) != null) {
                    seventh7.setImageDrawable(Drawable.createFromPath(seventhGeneration.getString(5)));
                } else {
                    seventh7Layout.removeView(seventh7);
                }
                seventh7Name.setText(seventhGeneration.getString(1));
            }
        }
        if (seventhGeneration.getCount() == 0) {
            second7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            third7.setAlpha(0.0f);
            fourth7.setAlpha(0.0f);
            fifth7.setAlpha(0.0f);
            sixth7.setAlpha(0.0f);
            seventh7.setAlpha(0.0f);
        }
        if (seventhGeneration.getCount() == 1) {
            third7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fourth7.setAlpha(0.0f);
            fifth7.setAlpha(0.0f);
            sixth7.setAlpha(0.0f);
            seventh7.setAlpha(0.0f);
        }
        if (seventhGeneration.getCount() == 2) {
            fourth7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            fifth7.setAlpha(0.0f);
            sixth7.setAlpha(0.0f);
            seventh7.setAlpha(0.0f);
        }
        if (seventhGeneration.getCount() == 3) {
            fifth7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            sixth7.setAlpha(0.0f);
            seventh7.setAlpha(0.0f);
        }
        if (seventhGeneration.getCount() == 4) {
            sixth7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
            seventh7.setAlpha(0.0f);
        }
        if (seventhGeneration.getCount() == 5) {
            seventh7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adding_press.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Intent intent = new Intent(TreeActivity.this, AddingActivity.class);
                            intent.putExtra("personGeneration", 7);
                            startActivityForResult(intent, 1);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    v.startAnimation(adding_press);
                }
            });
        }
        seventhGeneration.close();
        // Seventh generation

        if (seventh4.getAlpha() == 0.0f && seventh5.getAlpha() == 0.0f && seventh6.getAlpha() == 0.0f && seventh7.getAlpha() == 0.0f) {
            generationsTable.removeView(seventhRow);
        }
        if (sixth1.getAlpha() == 0.0f && sixth4.getAlpha() == 0.0f && sixth5.getAlpha() == 0.0f && sixth6.getAlpha() == 0.0f &&
                sixth7.getAlpha() == 0.0f) {
            generationsTable.removeView(sixthRow);
        }
        if (fifth1.getAlpha() == 0.0f && fifth3.getAlpha() == 0.0f && fifth4.getAlpha() == 0.0f && fifth5.getAlpha() == 0.0f &&
                fifth6.getAlpha() == 0.0f && fifth7.getAlpha() == 0.0f) {
            generationsTable.removeView(fifthRow);
        }
        if (fourth1.getAlpha() == 0.0f && fourth3.getAlpha() == 0.0f && fourth4.getAlpha() == 0.0f && fourth5.getAlpha() == 0.0f &&
                fourth6.getAlpha() == 0.0f && fourth7.getAlpha() == 0.0f) {
            generationsTable.removeView(fourthRow);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent finishRequest) {
        super.onActivityResult(requestCode, resultCode, finishRequest);
        if (finishRequest != null) {
            finish();
        }
    }
}