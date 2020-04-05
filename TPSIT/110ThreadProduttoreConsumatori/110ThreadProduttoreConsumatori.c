#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

typedef struct{
    pthread_mutex_t mtx_id;
    int data; 
    int cicli;
} Param;

typedef struct{
	int sum;
	int n;
} Return;

void* consumatore(void*);
void* produttore(void*);

int main(int argc, char** argv){
    pthread_t cons_id_1, cons_id_2, cons_id_3, prod_id;
    pthread_t vCons[3] = {cons_id_1, cons_id_2, cons_id_3};
    Param p;
    Return* ret_1;
    Return* ret_2;
    Return* ret_3;
    
    srand(time(NULL));

    if(argc != 2){
        printf("USAGE: %s CICLI", argv[0]);
        return -1;
    }
    
    /* Inserimento valori nella struttura dati di passaggio parametri */
    p.cicli = atoi(argv[1]);
    p.data = 0;
    
    /* Creazione mutex */
    int r = pthread_mutex_init(&p.mtx_id, NULL);
    if(r != 0){
        printf("Main: Errore nella creazione del mutex...\n");
        return -2;
    }
    
    /* Creazione thread produttore */
    r = pthread_create(&prod_id, NULL, produttore, (void*) &p);
    if(r != 0){
    	printf("Main: Errore nella creazione del thread produttore...\n");
    	return -3;
    } else {
    	printf("Main: Creato il thread produttore\n");
    }
       
    /* Creazione threads consumatori */
    for(int i = 0; i < 3; i++){
    	r = pthread_create(&vCons[i], NULL, consumatore, (void*) &p);
		if(r != 0){
        	printf("Main: Errore nella creazione del thread consumatore...\n");
        	return -4;
    	} else {
    		printf("Main: Creato il thread consumatore di ID [%li]\n", vCons[i]);
    	}
    }
    
	/* Attesa termine threads */
	printf("Main: Attesa del termine dei threads...\n");
	pthread_join(prod_id, NULL);
	
	pthread_join(vCons[0], (void**) &ret_1);
	pthread_join(vCons[1], (void**) &ret_2);
	pthread_join(vCons[2], (void**) &ret_3);
	
	/* Ricerca del thread con la somma maggiore */
	if((ret_1->sum > ret_2->sum) && (ret_1->sum > ret_3->sum)){
	    printf("Main: il thread di ID [%li] ha una somma di %d\n", vCons[0], ret_1->sum);
	} else if((ret_2->sum > ret_1->sum) && (ret_2->sum > ret_3->sum)) {
	    printf("Main: il thread di ID [%li] ha una somma di %d\n", vCons[1], ret_2->sum);
	} else {
	    printf("Main: il thread di ID [%li] ha una somma di %d\n", vCons[2], ret_3->sum);
	}
	
	/* Ricerca del thread con più numeri consumati */
	if((ret_1->n > ret_2->n) && (ret_1->n > ret_3->n)){
	    printf("Main: il thread di ID [%li] ha consumato %d numeri\n", vCons[0], ret_1->n);
	} else if((ret_2->n > ret_1->n) && (ret_2->n > ret_3->n)) {
	    printf("Main: il thread di ID [%li] ha consumato %d numeri\n", vCons[1], ret_2->n);
	} else {
	    printf("Main: il thread di ID [%li] ha consumato %d numeri\n", vCons[2], ret_3->n);
	}
	
	/* Deallocazione della memoria utilizzata */
	free(ret_1);
	free(ret_2);
	free(ret_3);
	
    return 0;
}

void* produttore(void* param){
	Param* p = (Param*) param;
	
	for(int i = 0; i <= p->cicli;){
		if(p->data == 0){
		    /* Inizio zona critica */
		    pthread_mutex_lock(&p->mtx_id);
		
		    if(i < p->cicli){
		    	p->data = rand() % 20 + 1;
		    	i++;
		    }
		    else if(i == p->cicli){
		    	p->data = -1;
		    	i++;
		    }
		
		    pthread_mutex_unlock(&p->mtx_id);
		    /* Fine zona critica */
	    }
	}
    return NULL;
}

void* consumatore(void* param){
    Param* p = (Param*) param;
    Return* ret = (Return*) malloc(sizeof(Return));
    
    int tot = 0;
    int n = 0;
    
	while(p->data != -1){
	
		/* Inizio zona critica */
		pthread_mutex_lock(&p->mtx_id);
		
		if(p->data > 0){
			ret->sum += p->data;
			ret->n += 1;
			
			printf("Thread [%li]: Totale somma %d, Numeri consumati %d\n", pthread_self(), ret->sum, ret->n);
			
			p->data = 0;
		}
		
		pthread_mutex_unlock(&p->mtx_id);
		/* Fine zona critica */
	}
	
    pthread_exit(ret);
}  
